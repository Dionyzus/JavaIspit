package com.dionyzus.crpytoClient.model;

public class Rate {
	private String time;
	private String asset_id_quote;
	private long rate;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAsset_id_quote() {
		return asset_id_quote;
	}
	public void setAsset_id_quote(String asset_id_quote) {
		this.asset_id_quote = asset_id_quote;
	}
	public long getRate() {
		return rate;
	}
	public void setRate(long rate) {
		this.rate = rate;
	}
	
}
