package com.example.labjava.repository;

import com.example.labjava.model.Skateboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkateboardRepository extends JpaRepository<Skateboard, Long> {

}
