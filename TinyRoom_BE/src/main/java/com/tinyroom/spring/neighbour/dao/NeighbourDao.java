package com.tinyroom.spring.neighbour.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tinyroom.spring.neighbour.domain.Neighbour;

public interface NeighbourDao extends JpaRepository<Neighbour, Integer>{

}
