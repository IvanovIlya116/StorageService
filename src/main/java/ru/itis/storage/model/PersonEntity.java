package ru.itis.storage.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;
    private String middleName;
    private String gender;
    private String birthDate;
    private String birthPlace;
    private String snils;
    private String inn;
    private String passportSeries;
    private String passportNumber;
    private String registrationAddress;
    private String residentialAddress;
    private String workplace;
    private String position;
    private String education;
}
