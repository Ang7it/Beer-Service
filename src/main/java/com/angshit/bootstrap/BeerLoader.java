package com.angshit.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.angshit.domain.Beer;
import com.angshit.repository.BeerRepository;

@Component
public class BeerLoader implements CommandLineRunner{

	private final BeerRepository beerRepository;
	
	public BeerLoader(BeerRepository beerRepository) {
		this.beerRepository = beerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		loadBeerObjects();
	}
	
	public void loadBeerObjects() {
		if(beerRepository.count()==0) {
			beerRepository.save(Beer
					.builder()
					.beerName("Heineken")
					.beerStyle("IPA")
					.quantityToBrew(200)
					.minOnHand(100)
					.upc(123456789L)
					.price(new BigDecimal("14.00"))
					.build());
			
			beerRepository.save(Beer
					.builder()
					.beerName("Miller")
					.beerStyle("ALE")
					.quantityToBrew(150)
					.minOnHand(100)
					.upc(987654321L)
					.price(new BigDecimal("12.95"))
					.build());
		}
		
		System.out.println("Loaded Repository:"+beerRepository.count());
	}
}
