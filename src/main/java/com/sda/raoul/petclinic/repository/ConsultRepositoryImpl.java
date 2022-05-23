package com.sda.raoul.petclinic.repository;

import com.sda.raoul.petclinic.model.Consult;
import com.sda.raoul.petclinic.repository.base.BaseRepositoryImpl;

public class ConsultRepositoryImpl extends BaseRepositoryImpl<Consult, Long> implements ConsultRepository {
    public ConsultRepositoryImpl() {
        super(Consult.class);
    }
}
