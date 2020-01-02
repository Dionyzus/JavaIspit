package com.dionyzus.crpytoClient.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "pair", "base", "quote", "markets" })
public class Datum {

	@JsonProperty("pair")
	private String pair;
	@JsonProperty("base")
	private Base base;
	@JsonProperty("quote")
	private Quote quote;
	@JsonProperty("markets")
	private List<Market> markets = new ArrayList<Market>();

	@JsonProperty("pair")
	public String getPair() {
		return pair;
	}

	@JsonProperty("pair")
	public void setPair(String pair) {
		this.pair = pair;
	}

	@JsonProperty("base")
	public Base getBase() {
		return base;
	}

	@JsonProperty("base")
	public void setBase(Base base) {
		this.base = base;
	}

	@JsonProperty("quote")
	public Quote getQuote() {
		return quote;
	}

	@JsonProperty("quote")
	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	@JsonProperty("markets")
	public List<Market> getMarkets() {
		return markets;
	}

	@JsonProperty("markets")
	public void setMarkets(List<Market> markets) {
		this.markets = markets;
	}

}