package ru.itis.storage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.storage.model.PersonEntity;
import ru.itis.storage.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public PersonEntity savePerson(PersonEntity person) {
        return personRepository.save(person);
    }

    public List<PersonEntity> getAllPersons() {
        return personRepository.findAll();
    }
}