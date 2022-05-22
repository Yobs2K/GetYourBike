package com.example.labjava.repository;

import com.example.labjava.model.Skatewheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkatewheelRepository extends JpaRepository<Skatewheel, Long> {

}
