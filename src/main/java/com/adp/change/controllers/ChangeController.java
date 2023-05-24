package com.adp.change.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.adp.change.model.CoinChanges;
import com.adp.change.service.CoinsService;

@RestController
public class ChangeController {

	@Autowired
	private CoinsService service;
	
	@GetMapping(value="/coins/{bill}")
	public ResponseEntity<CoinChanges> changeRequest(@PathVariable Integer bill) throws Exception {
		
		CoinChanges changes = service.checkingAvailableConins(bill);
		
		return new ResponseEntity<>(changes, HttpStatus.OK);
	}

	
}
