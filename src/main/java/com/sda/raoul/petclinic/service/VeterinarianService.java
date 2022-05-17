package com.sda.raoul.petclinic.service;

import com.sda.raoul.petclinic.service.dto.VeterinarianDTO;
import com.sda.raoul.petclinic.service.exception.InvalidParameterException;

import java.util.List;

public interface VeterinarianService {

    void create(String firstName,String lastName,String address, String speciality) throws InvalidParameterException;

    List<VeterinarianDTO> findAll();
}
