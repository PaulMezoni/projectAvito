package com.amr.project.model.entity_refactor.populateDB.repository;

import com.amr.project.model.entity_refactor.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
