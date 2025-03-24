package ru.itis.storage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.storage.model.PersonEntity;
import ru.itis.storage.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/save")
    public ResponseEntity<PersonEntity> savePerson(@RequestBody PersonEntity person) {
        PersonEntity savedPerson = personService.savePerson(person);
        return ResponseEntity.ok(savedPerson);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonEntity>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }
}