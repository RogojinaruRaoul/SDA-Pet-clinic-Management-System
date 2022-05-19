package com.sda.raoul.petclinic.repository;

import com.sda.raoul.petclinic.model.Pet;
import com.sda.raoul.petclinic.repository.base.BaseRepository;

import java.util.List;

public interface PetRepository extends BaseRepository<Pet, Long> {
    List<Pet> findAllVaccinated();

}
