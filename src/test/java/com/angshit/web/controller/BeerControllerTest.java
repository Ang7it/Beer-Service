package com.angshit.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.angshit.web.model.BeerDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void getBeerById() throws Exception {
	
		mockMvc
			.perform(get("http://localhost:9090/api/v1/beer/"+UUID.randomUUID().toString())).andExpect(status().isOk());
		
	}
	
	@Test
	void updateBeerById() throws Exception {
		
		BeerDto beerDto=BeerDto.builder().build();
		String beertDtoJson=objectMapper.writeValueAsString(beerDto);
		
		mockMvc
			.perform(put("http://localhost:9090/api/v1/beer/"+UUID.randomUUID().toString())
			.contentType(MediaType.APPLICATION_JSON)
			.content(beertDtoJson))
			.andExpect(status().isNoContent());
		
	}
	
	@Test
	void saveNewBeer() throws Exception {
	
		BeerDto beerDto=BeerDto.builder().build();
		String beerDtoJson=objectMapper.writeValueAsString(beerDto);
		
		mockMvc
			.perform(post("http://localhost:9090/api/v1/beer/")
			.contentType(MediaType.APPLICATION_JSON)
			.content(beerDtoJson))
			.andExpect(status().isCreated());
	}
	
}
