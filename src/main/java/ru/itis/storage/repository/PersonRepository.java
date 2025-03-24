package ru.itis.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.storage.model.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}