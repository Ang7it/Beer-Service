package com.angshit.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angshit.domain.Beer;


@Repository
public interface BeerRepository extends JpaRepository<Beer, UUID>{

}
