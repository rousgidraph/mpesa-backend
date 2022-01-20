package com.example.mpesabackend;

import com.example.mpesabackend.dtos.AcknowledgeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MpesaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpesaBackendApplication.class, args);
	}

	@Bean
	public OkHttpClient getOkhttpClient(){
		return new OkHttpClient();
	}

	@Bean
	public ObjectMapper getObjectMapper(){
		return new ObjectMapper();
	}

	@Bean
	public AcknowledgeResponse getAcknowledgeResponse(){
		AcknowledgeResponse acknowledgeResponse = new AcknowledgeResponse();
		acknowledgeResponse.setMessage("Success");
		return acknowledgeResponse;
	}
}
