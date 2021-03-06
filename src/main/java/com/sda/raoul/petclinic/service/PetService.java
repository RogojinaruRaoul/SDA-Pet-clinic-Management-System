package com.sda.raoul.petclinic.service;

import com.sda.raoul.petclinic.model.Pet;
import com.sda.raoul.petclinic.service.dto.PetDTO;
import com.sda.raoul.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.List;

public interface PetService {

    void create(String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName) throws InvalidParameterException;

    List<Pet> findAllVaccinated();

    List<PetDTO> findAll();

    void deleteById(Long id);

    void updateById(Long id, String race, Date birthDate, boolean isVaccinated,String ownerFirstName, String ownerLastName) throws InvalidParameterException;

}
