package com.example.mpesabackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StkPushSyncResponse{

	@JsonProperty("MerchantRequestID")
	private String merchantRequestID;

	@JsonProperty("ResponseCode")
	private String responseCode;

	@JsonProperty("CustomerMessage")
	private String customerMessage;

	@JsonProperty("CheckoutRequestID")
	private String checkoutRequestID;

	@JsonProperty("ResponseDescription")
	private String responseDescription;

	public String getMerchantRequestID(){
		return merchantRequestID;
	}

	public String getResponseCode(){
		return responseCode;
	}

	public String getCustomerMessage(){
		return customerMessage;
	}

	public String getCheckoutRequestID(){
		return checkoutRequestID;
	}

	public String getResponseDescription(){
		return responseDescription;
	}
}