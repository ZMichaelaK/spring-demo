package com.lbg.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.River;

public interface RiverRepo extends JpaRepository<River, Integer> {

}
