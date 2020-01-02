package com.dionyzus.crpytoClient.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "exchange", "pair", "start_date" })
public class Market {

	@JsonProperty("exchange")
	private String exchange;
	@JsonProperty("pair")
	private String pair;
	@JsonProperty("start_date")
	private String startDate;

	@JsonProperty("exchange")
	public String getExchange() {
		return exchange;
	}

	@JsonProperty("exchange")
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	@JsonProperty("pair")
	public String getPair() {
		return pair;
	}

	@JsonProperty("pair")
	public void setPair(String pair) {
		this.pair = pair;
	}

	@JsonProperty("start_date")
	public String getStartDate() {
		return startDate;
	}

	@JsonProperty("start_date")
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}