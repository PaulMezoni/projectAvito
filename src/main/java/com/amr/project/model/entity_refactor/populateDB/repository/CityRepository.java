package com.amr.project.model.entity_refactor.populateDB.repository;

import com.amr.project.model.entity_refactor.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);
}
