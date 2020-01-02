package com.dionyzus.crypto.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dionyzus.crypto.repository.PricesRepository;
import com.dionyzus.crypto.service.PriceService;

@Component
@EnableScheduling
public class SchedulingTasks {
    
    @Autowired
    private PriceService priceService;
    
    @Autowired
    private PricesRepository pricesRepository;
    
    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    
    @Scheduled(fixedDelay = MINUTO)
    public void reportPrice(String id) {
    	if(pricesRepository.findByName(id).isStatus()) {
    		priceService.initMonitoringOfPrice(pricesRepository.findByName(id).getPrice(),pricesRepository.findByName(id).getId());
    	}
    }
	
}