package com.dionyzus.crpytoClient.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "symbol", "rank", "circulating_supply", "total_supply", "max_supply", "beta_value",
		"last_updated", "quotes" })
public class CryptoPaprika {

	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("symbol")
	private String symbol;
	@JsonProperty("rank")
	private Integer rank;
	@JsonProperty("circulating_supply")
	private Long circulatingSupply;
	@JsonProperty("total_supply")
	private Long totalSupply;
	@JsonProperty("max_supply")
	private Long maxSupply;
	@JsonProperty("beta_value")
	private Double betaValue;
	@JsonProperty("last_updated")
	private String lastUpdated;
	@JsonProperty("quotes")
	private Quotes quotes;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("symbol")
	public String getSymbol() {
		return symbol;
	}

	@JsonProperty("symbol")
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@JsonProperty("rank")
	public Integer getRank() {
		return rank;
	}

	@JsonProperty("rank")
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@JsonProperty("circulating_supply")
	public Long getCirculatingSupply() {
		return circulatingSupply;
	}

	@JsonProperty("circulating_supply")
	public void setCirculatingSupply(Long circulatingSupply) {
		this.circulatingSupply = circulatingSupply;
	}

	@JsonProperty("total_supply")
	public Long getTotalSupply() {
		return totalSupply;
	}

	@JsonProperty("total_supply")
	public void setTotalSupply(Long totalSupply) {
		this.totalSupply = totalSupply;
	}

	@JsonProperty("max_supply")
	public Long getMaxSupply() {
		return maxSupply;
	}

	@JsonProperty("max_supply")
	public void setMaxSupply(Long maxSupply) {
		this.maxSupply = maxSupply;
	}

	@JsonProperty("beta_value")
	public Double getBetaValue() {
		return betaValue;
	}

	@JsonProperty("beta_value")
	public void setBetaValue(Double betaValue) {
		this.betaValue = betaValue;
	}

	@JsonProperty("last_updated")
	public String getLastUpdated() {
		return lastUpdated;
	}

	@JsonProperty("last_updated")
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@JsonProperty("quotes")
	public Quotes getQuotes() {
		return quotes;
	}

	@JsonProperty("quotes")
	public void setQuotes(Quotes quotes) {
		this.quotes = quotes;
	}

}