package com.sda.raoul.petclinic.service;

import java.util.Date;

public interface ConsultService {

    void create(Long veterinarianId,Long petId,Date date, String description);
}
