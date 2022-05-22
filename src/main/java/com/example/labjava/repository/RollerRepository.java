package com.example.labjava.repository;

import com.example.labjava.model.Roller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RollerRepository extends JpaRepository<Roller, Long> {

}
