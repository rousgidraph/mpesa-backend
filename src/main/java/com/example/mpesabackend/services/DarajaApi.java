package com.example.mpesabackend.services;

import com.example.mpesabackend.dtos.*;

public interface DarajaApi {
    /**
     * returns daraja acess token response
     * */

    AccessTokenResponse getAccessToken();

    RegisterUrlResponse registerUrl();

    SimulateC2BResponse simulateC2BTransaction(SimulateC2BRequest simulateC2BRequest);

    //B2CTransactionsyncResponse performB2Ctransaction(InternalB2CTransactionRequest internalB2CTransactionRequest);


    StkPushSyncResponse performStkPushTransaction(InternalStkPushRequest internalStkPushRequest);

}
