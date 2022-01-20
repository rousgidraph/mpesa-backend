package com.example.mpesabackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StkPushAsyncResponse{

	@JsonProperty("Body")
	private Body body;

	public Body getBody(){
		return body;
	}
}