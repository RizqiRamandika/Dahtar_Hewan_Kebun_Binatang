package com.data.animal.animal.service;

import com.data.animal.animal.model.Animal;
import com.data.animal.animal.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepo;

    public List<Animal> listAll() {
        return animalRepo.findAll();
    }

    public void save(Animal animal) {
        animalRepo.save(animal);
    }

    public Animal get(long id) {
        return animalRepo.findById(id).get();
    }

    public void delete(long id) {
        animalRepo.deleteById(id);
    }

}
