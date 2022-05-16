package com.sda.raoul.petclinic.repository;

import com.sda.raoul.petclinic.model.Veterinarian;
import com.sda.raoul.petclinic.repository.base.BaseRepositoryImpl;

public class VeterinarianRepositoryImpl extends BaseRepositoryImpl<Veterinarian, Long> implements VeterinarianRepository {
    public VeterinarianRepositoryImpl() {
        super(Veterinarian.class);
    }
}
