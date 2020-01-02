package com.dionyzus.crpytoClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dionyzus.cryptoClient.ClientRepo.FavouriteRepository;
import com.dionyzus.cryptoClient.domain.Favourite;

@Controller
public class StatsController {

	@Autowired
	FavouriteRepository favouriteRepository;

	@RequestMapping("/stats")
	public String product(Model model) {
		model.addAttribute("stats", favouriteRepository.findAll());
		return "statistics";
	}

	@RequestMapping("/create")
	public String create(Model model) {
		return "create";
	}
	

	@RequestMapping("/save")
	public String save(@RequestParam String cryptoName, @RequestParam String cryptoRateInUSD,
			@RequestParam String time) {
		Favourite fav = new Favourite();
		fav.setCryptoName(cryptoName);
		fav.setCryptoRateInUSD(cryptoRateInUSD);
		fav.setTime(time);

		favouriteRepository.save(fav);

		return "dashboard";
	}

}
