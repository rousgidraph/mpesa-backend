package com.example.mpesabackend.controllers;


import com.example.mpesabackend.dtos.AcknowledgeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("")
public class sampleController {

    private final AcknowledgeResponse acknowledgeResponse;

    public sampleController( AcknowledgeResponse acknowledgeResponse){
        this.acknowledgeResponse =acknowledgeResponse;
    }

    @GetMapping(path="/sample", produces = "application/json")
    public String sampleMessage(){
        return "Spring Controller working";
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/status", produces = "application/json")
    public ResponseEntity<AcknowledgeResponse> something(){
        return ResponseEntity.ok(acknowledgeResponse);
    }
}
