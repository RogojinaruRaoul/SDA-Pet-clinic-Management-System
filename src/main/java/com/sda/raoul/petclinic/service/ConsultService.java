package com.sda.raoul.petclinic.service;

import com.sda.raoul.petclinic.service.exception.InvalidParameterException;

import java.util.Date;

public interface ConsultService {

    void create(Long veterinarianId,Long petId,Date date, String description)throws InvalidParameterException;
}
