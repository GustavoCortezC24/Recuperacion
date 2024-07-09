package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.services.PetService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class PetServiceIntegrationTest {

    @Autowired
    private PetService petService;

    @Test
    public void testFindAllPets() {

        List<Pet> pets = (List<Pet>) petService.findAll();
        assertNotNull(pets);
        assertEquals(13, pets.size());
    }

    @Test
    public void testFindPetById() throws PetNotFoundException {

        long petId = 1L;
        Pet pet = petService.findById(petId);
        assertNotNull(pet);
        assertEquals("Leo", pet.getName());
    }


}
