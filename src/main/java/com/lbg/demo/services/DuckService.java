package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Duck;
import com.lbg.demo.repos.DuckRepo;

@Service
public class DuckService {
	private DuckRepo repo;

	public DuckService(DuckRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Duck> createDuck(Duck newDuck) {
		Duck created = this.repo.save(newDuck);
		return new ResponseEntity<Duck>(created, HttpStatus.CREATED);
	}

	public List<Duck> getDucks() {
		return this.repo.findAll();
	}

	public ResponseEntity<Duck> getDuck(int id) {
		Optional<Duck> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Duck>(HttpStatus.NOT_FOUND);
		}

		Duck body = found.get();

		return ResponseEntity.ok(body);

	}

	public ResponseEntity<Duck> updateDuck(int id, Duck newDuck) {
		Optional<Duck> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Duck>(HttpStatus.NOT_FOUND);
		}

		Duck existing = found.get();

		if (newDuck.getName() != null) {
			existing.setName(newDuck.getName());
		}

		if (newDuck.getSuperColour() != null) {
			existing.setSuperColour(newDuck.getSuperColour());
		}

		Duck updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean remove(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}
}