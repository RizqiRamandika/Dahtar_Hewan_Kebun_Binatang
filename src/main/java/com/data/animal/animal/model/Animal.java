package com.data.animal.animal.model;

import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {

    @Column(name = "animal_name")
    private String animalName;

    @Column(name = "animal_age")
    private String animalAge;

    @Column(name = "animal_gender")
    private String animalGender;

    public Animal() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(String animalAge) {
        this.animalAge = animalAge;
    }

    public String getAnimalGender() {
        return animalGender;
    }

    public void setAnimalGender(String animalGender) {
        this.animalGender = animalGender;
    }
}