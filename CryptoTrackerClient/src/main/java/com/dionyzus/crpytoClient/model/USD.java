package com.dionyzus.crpytoClient.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "price", "volume_24h", "volume_24h_change_24h", "market_cap", "market_cap_change_24h",
		"percent_change_1h", "percent_change_12h", "percent_change_24h", "percent_change_7d", "percent_change_30d",
		"percent_change_1y", "ath_price", "ath_date", "percent_from_price_ath" })
public class USD {

	@JsonProperty("price")
	private Double price;
	@JsonProperty("volume_24h")
	private Double volume24h;
	@JsonProperty("volume_24h_change_24h")
	private Double volume24hChange24h;
	@JsonProperty("market_cap")
	private Long marketCap;
	@JsonProperty("market_cap_change_24h")
	private Double marketCapChange24h;
	@JsonProperty("percent_change_1h")
	private Double percentChange1h;
	@JsonProperty("percent_change_12h")
	private Double percentChange12h;
	@JsonProperty("percent_change_24h")
	private Double percentChange24h;
	@JsonProperty("percent_change_7d")
	private Double percentChange7d;
	@JsonProperty("percent_change_30d")
	private Double percentChange30d;
	@JsonProperty("percent_change_1y")
	private Double percentChange1y;
	@JsonProperty("ath_price")
	private Long athPrice;
	@JsonProperty("ath_date")
	private String athDate;
	@JsonProperty("percent_from_price_ath")
	private Double percentFromPriceAth;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("price")
	public Double getPrice() {
		return price;
	}

	@JsonProperty("price")
	public void setPrice(Double price) {
		this.price = price;
	}

	@JsonProperty("volume_24h")
	public Double getVolume24h() {
		return volume24h;
	}

	@JsonProperty("volume_24h")
	public void setVolume24h(Double volume24h) {
		this.volume24h = volume24h;
	}

	@JsonProperty("volume_24h_change_24h")
	public Double getVolume24hChange24h() {
		return volume24hChange24h;
	}

	@JsonProperty("volume_24h_change_24h")
	public void setVolume24hChange24h(Double volume24hChange24h) {
		this.volume24hChange24h = volume24hChange24h;
	}

	@JsonProperty("market_cap")
	public Long getMarketCap() {
		return marketCap;
	}

	@JsonProperty("market_cap")
	public void setMarketCap(Long marketCap) {
		this.marketCap = marketCap;
	}

	@JsonProperty("market_cap_change_24h")
	public Double getMarketCapChange24h() {
		return marketCapChange24h;
	}

	@JsonProperty("market_cap_change_24h")
	public void setMarketCapChange24h(Double marketCapChange24h) {
		this.marketCapChange24h = marketCapChange24h;
	}

	@JsonProperty("percent_change_1h")
	public Double getPercentChange1h() {
		return percentChange1h;
	}

	@JsonProperty("percent_change_1h")
	public void setPercentChange1h(Double percentChange1h) {
		this.percentChange1h = percentChange1h;
	}

	@JsonProperty("percent_change_12h")
	public Double getPercentChange12h() {
		return percentChange12h;
	}

	@JsonProperty("percent_change_12h")
	public void setPercentChange12h(Double percentChange12h) {
		this.percentChange12h = percentChange12h;
	}

	@JsonProperty("percent_change_24h")
	public Double getPercentChange24h() {
		return percentChange24h;
	}

	@JsonProperty("percent_change_24h")
	public void setPercentChange24h(Double percentChange24h) {
		this.percentChange24h = percentChange24h;
	}

	@JsonProperty("percent_change_7d")
	public Double getPercentChange7d() {
		return percentChange7d;
	}

	@JsonProperty("percent_change_7d")
	public void setPercentChange7d(Double percentChange7d) {
		this.percentChange7d = percentChange7d;
	}

	@JsonProperty("percent_change_30d")
	public Double getPercentChange30d() {
		return percentChange30d;
	}

	@JsonProperty("percent_change_30d")
	public void setPercentChange30d(Double percentChange30d) {
		this.percentChange30d = percentChange30d;
	}

	@JsonProperty("percent_change_1y")
	public Double getPercentChange1y() {
		return percentChange1y;
	}

	@JsonProperty("percent_change_1y")
	public void setPercentChange1y(Double percentChange1y) {
		this.percentChange1y = percentChange1y;
	}

	@JsonProperty("ath_price")
	public Long getAthPrice() {
		return athPrice;
	}

	@JsonProperty("ath_price")
	public void setAthPrice(Long athPrice) {
		this.athPrice = athPrice;
	}

	@JsonProperty("ath_date")
	public String getAthDate() {
		return athDate;
	}

	@JsonProperty("ath_date")
	public void setAthDate(String athDate) {
		this.athDate = athDate;
	}

	@JsonProperty("percent_from_price_ath")
	public Double getPercentFromPriceAth() {
		return percentFromPriceAth;
	}

	@JsonProperty("percent_from_price_ath")
	public void setPercentFromPriceAth(Double percentFromPriceAth) {
		this.percentFromPriceAth = percentFromPriceAth;
	}

}