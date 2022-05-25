package com.example.labjava.repository;

import com.example.labjava.model.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle, Long> {
    public List<Bicycle> findBicycleByStyle(String style);

    @Query("SELECT style FROM Bicycle GROUP BY style")
    public List<String> getAllStyles();
}
