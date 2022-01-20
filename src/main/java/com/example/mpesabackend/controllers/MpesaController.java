package com.example.mpesabackend.controllers;

import com.example.mpesabackend.dtos.*;
import com.example.mpesabackend.services.DarajaApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("mobile-money")
@Slf4j
public class MpesaController {
    private final DarajaApi darajaApi;
    private final AcknowledgeResponse acknowledgeResponse;
    private final ObjectMapper objectMapper;

    public MpesaController(DarajaApi darajaApi, AcknowledgeResponse acknowledgeResponse, ObjectMapper objectMapper)
    {
        this.darajaApi = darajaApi;
        this.acknowledgeResponse = acknowledgeResponse;
        this.objectMapper = objectMapper;
    }

    @GetMapping(path = "/token",produces = "application/json")
    public ResponseEntity<AccessTokenResponse> getAccessToken(){
        return ResponseEntity.ok(darajaApi.getAccessToken());
    }

    @GetMapping(path = "/register-url",produces = "application/json")
    public  ResponseEntity<RegisterUrlResponse> registerUrl(){
        return  ResponseEntity.ok(darajaApi.registerUrl());
    }

    @PostMapping(path = "/validation",produces = "application/json")
    public ResponseEntity<AcknowledgeResponse> validateTransaction(@RequestBody MpesaValidationResponse mpesaValidationResponse){
        System.out.println(mpesaValidationResponse.getBillRefNumber());
        return ResponseEntity.ok(acknowledgeResponse);
    }

    @PostMapping(path = "/simulate-c2b",produces = "application/json")
   public ResponseEntity<SimulateC2BResponse> simulateC2BTransaction(@RequestBody SimulateC2BRequest simulateC2BRequest){
        return ResponseEntity.ok(darajaApi.simulateC2BTransaction(simulateC2BRequest));
   }

   @PostMapping(path = "/b2c-transaction-result", produces = "application/json")
   public ResponseEntity<AcknowledgeResponse> b2cTransactionAsyncResults(@RequestBody B2CTransactionAsyncResponse b2CTransactionAsyncResponse)
   throws JsonProcessingException {
       log.info("============ B2C Transaction Response =============");
       log.info(objectMapper.writeValueAsString(b2CTransactionAsyncResponse));
       return ResponseEntity.ok(acknowledgeResponse);
   }

    @PostMapping(path = "/stk-transaction-request", produces = "application/json")
    public ResponseEntity<StkPushSyncResponse> performStkPushTransaction(@RequestBody InternalStkPushRequest internalStkPushRequest) {
        return ResponseEntity.ok(darajaApi.performStkPushTransaction(internalStkPushRequest));
    }

    @SneakyThrows
    @PostMapping(path = "/stk-transaction-result", produces = "application/json")
    public ResponseEntity<AcknowledgeResponse> acknowledgeStkPushResponse(@RequestBody StkPushAsyncResponse stkPushAsyncResponse) {
        log.info("======= STK Push Async Response =====");
        log.info(objectMapper.writeValueAsString(stkPushAsyncResponse));
        return ResponseEntity.ok(acknowledgeResponse);
    }

}
