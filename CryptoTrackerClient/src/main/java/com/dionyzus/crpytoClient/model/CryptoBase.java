package com.dionyzus.crpytoClient.model;

import java.util.ArrayList;

public class CryptoBase {

	private String asset_id_base;
	private ArrayList<Rate> rates;
	
	public String getAsset_id_base() {
		return asset_id_base;
	}
	public void setAsset_id_base(String asset_id_base) {
		this.asset_id_base = asset_id_base;
	}
	public ArrayList<Rate> getRates() {
		return rates;
	}
	public void setRates(ArrayList<Rate> rates) {
		this.rates = rates;
	}
	
}
