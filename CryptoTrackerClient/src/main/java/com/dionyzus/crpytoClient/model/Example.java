package com.dionyzus.crpytoClient.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "result", "server_time", "data" })
public class Example {

	@JsonProperty("result")
	private String result;
	@JsonProperty("server_time")
	private String serverTime;
	@JsonProperty("data")
	private List<Datum> data = new ArrayList<Datum>();

	@JsonProperty("result")
	public String getResult() {
		return result;
	}

	@JsonProperty("result")
	public void setResult(String result) {
		this.result = result;
	}

	@JsonProperty("server_time")
	public String getServerTime() {
		return serverTime;
	}

	@JsonProperty("server_time")
	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}

	@JsonProperty("data")
	public List<Datum> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<Datum> data) {
		this.data = data;
	}

}