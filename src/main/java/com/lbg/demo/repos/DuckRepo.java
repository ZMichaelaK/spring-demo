package com.lbg.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Duck;

public interface DuckRepo extends JpaRepository<Duck, Integer> {

}
