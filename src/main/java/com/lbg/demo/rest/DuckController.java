package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Duck;
import com.lbg.demo.services.DuckService;

@RestController
@RequestMapping("/duck")
public class DuckController {

	private DuckService service;

	public DuckController(DuckService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Duck> createDuck(@RequestBody Duck newDuck) {
		return this.service.createDuck(newDuck);
	}

	@GetMapping("/get")
	public List<Duck> getDucks() {
		return this.service.getDucks();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Duck> getDuck(@PathVariable int id) {
		return this.service.getDuck(id);
	}

	@DeleteMapping("/remove/{id}")
	public boolean remove(@PathVariable int id) {
		return this.service.remove(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Duck> updateDuck(@PathVariable int id, @RequestBody Duck newDuck) {
		return this.service.updateDuck(id, newDuck);
	}
}
