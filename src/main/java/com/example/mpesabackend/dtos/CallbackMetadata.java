package com.example.mpesabackend.dtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CallbackMetadata{

	@JsonProperty("Item")
	private List<ItemItem> item;

	public List<ItemItem> getItem(){
		return item;
	}
}