package com.amr.project.model.entity_refactor.populateDB.repository;

import com.amr.project.model.entity_refactor.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByName(String name);
}
