package com.sda.raoul.petclinic.repository;

import com.sda.raoul.petclinic.model.Consult;
import com.sda.raoul.petclinic.repository.base.BaseRepository;

import java.util.Date;
import java.util.List;

public interface ConsultRepository extends BaseRepository<Consult,Long> {
    List<Consult> findAllWithUnvaccinatedPets();
    List<Consult> findAllByVetIdAndDateBetween(Long vetID, Date startDate, Date endDate);

}
