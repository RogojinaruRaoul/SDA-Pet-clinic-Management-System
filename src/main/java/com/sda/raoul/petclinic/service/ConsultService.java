package com.sda.raoul.petclinic.service;

import com.sda.raoul.petclinic.model.Consult;
import com.sda.raoul.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.List;

public interface ConsultService {

    void create(Long veterinarianId,Long petId,Date date, String description)throws InvalidParameterException;

    List<Consult> findAllWithUnvaccinatedPets();

}
