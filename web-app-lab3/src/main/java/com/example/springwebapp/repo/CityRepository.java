package com.example.springwebapp.repo;

import com.example.springwebapp.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String name);
}
