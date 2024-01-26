package com.lbg.demo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.River;
import com.lbg.demo.services.RiverService;

@RestController
@RequestMapping("/river")
public class RiverController {
	private RiverService service;

	public RiverController(RiverService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<River> createRiver(@RequestBody River newRiver) {
		return this.service.createRiver(newRiver);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<River> getRiver(@PathVariable int id) {
		return this.service.read(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<River> updateRiver(@PathVariable int id, @RequestBody River newRiver) {
		return this.service.getRiver(id, newRiver);
	}

	@DeleteMapping("/remove/{id}")
	public boolean delete(@PathVariable int id) {
		return this.service.delete(id);
	}
}
