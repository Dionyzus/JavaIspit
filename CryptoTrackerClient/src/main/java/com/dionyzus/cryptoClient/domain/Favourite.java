package com.dionyzus.cryptoClient.domain;


import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "favourite")
public class Favourite {
	
	@Id
    private String id;
    @Indexed(direction = IndexDirection.DESCENDING, dropDups = true)
    private String cryptoName;
    private String cryptoRateInUSD;
    private String time;
   
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCryptoName() {
		return cryptoName;
	}
	public void setCryptoName(String cryptoName) {
		this.cryptoName = cryptoName;
	}
	public String getCryptoRateInUSD() {
		return cryptoRateInUSD;
	}
	public void setCryptoRateInUSD(String cryptoRateInUSD) {
		this.cryptoRateInUSD = cryptoRateInUSD;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}