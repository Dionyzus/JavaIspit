package com.dionyzus.crpytoClient.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "USD" })
public class Quotes {

	@JsonProperty("USD")
	private USD uSD;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("USD")
	public USD getUSD() {
		return uSD;
	}

	@JsonProperty("USD")
	public void setUSD(USD uSD) {
		this.uSD = uSD;
	}

}