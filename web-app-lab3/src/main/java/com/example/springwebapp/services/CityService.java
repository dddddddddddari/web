package com.example.springwebapp.services;

import com.example.springwebapp.models.City;
import com.example.springwebapp.repo.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }
    public City getByName(String name) {
        return cityRepository.findByName(name);
    }
}
