package com.amr.project.model.entity_refactor.populateDB.repository;

import com.amr.project.model.entity_refactor.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
