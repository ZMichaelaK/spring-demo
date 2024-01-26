package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.River;
import com.lbg.demo.repos.RiverRepo;

@Service
public class RiverService {
	private RiverRepo repo;

	public RiverService(RiverRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<River> createRiver(River newRiver) {
		River created = this.repo.save(newRiver);
		return new ResponseEntity<River>(created, HttpStatus.CREATED);
	}

	public List<River> readAll() {
		return this.repo.findAll();
	}

	public ResponseEntity<River> getRiver(int id, River newRiver) {
		Optional<River> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<River>(HttpStatus.NOT_FOUND);
		}

		River existing = found.get();

		if (newRiver.getName() != null) {
			existing.setName(newRiver.getName());
		}

		if (newRiver.getCountry() != null) {
			existing.setCountry(newRiver.getCountry());
		}

		River updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public ResponseEntity<River> read(int id) {
		Optional<River> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(found.get());
	}

	public boolean delete(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}
}