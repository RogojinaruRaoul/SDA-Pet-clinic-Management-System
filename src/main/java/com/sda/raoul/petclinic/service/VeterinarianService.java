package com.sda.raoul.petclinic.service;

import com.sda.raoul.petclinic.service.exception.InvalidParameterException;

public interface VeterinarianService {

    void create(String firstName,String lastName,String address, String speciality) throws InvalidParameterException;
}
