package com.anil.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerApiSerivceController {

	@Autowired
	private RestTemplate restTemplate;

	private static String curdOperationURL = "http://localhost:9092/api/getAlladdress";
	private static String springBootAppURL = "http://localhost:9091/application/allUsers/";

	@GetMapping("/msg")
	public String getMessage() {
		return "get the successful mesg";
	}

	@GetMapping("/getConsumercurdApi")
	public String consumecurdOperationService() {
		String curdApiURL = restTemplate.getForObject(curdOperationURL, String.class);
		return "get all user details..." + curdApiURL;

	}

	@GetMapping("/getConsumerspringBootApp")
	public String consumeservice() {
		String userDetails = restTemplate.getForObject(springBootAppURL, String.class);
		return "get all user details..." + userDetails;
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}
