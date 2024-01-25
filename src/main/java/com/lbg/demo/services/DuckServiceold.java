//package com.lbg.demo.services;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.lbg.demo.domain.Duck;
//
//@Service
//public class DuckService {
//	private List<Duck> ducks = new ArrayList<>();
//
//	public ResponseEntity<Duck> createDuck(Duck newDuck) {
//		this.ducks.add(newDuck);
//		Duck body = this.ducks.get(this.ducks.size() - 1);
//		return new ResponseEntity<Duck>(body, HttpStatus.CREATED);
//	}
//
//	public List<Duck> getDucks() {
//		return ducks;
//	}
//
//	public ResponseEntity<Duck> getDuck(int id) {
//		if (id < 0 || id >= this.ducks.size()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		Duck found = this.ducks.get(id);
//		return ResponseEntity.ok(found);
//	}
//
//	public Duck removeDuck(int id) {
//		return this.ducks.remove(id);
//	}
//
//	public Duck updateDuck(int id, Duck newDuck) {
//		return this.ducks.set(id, newDuck);
//	}
//}
