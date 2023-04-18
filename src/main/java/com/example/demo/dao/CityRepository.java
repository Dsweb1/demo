package com.example.demo.dao;

import com.example.demo.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,String> {
}
