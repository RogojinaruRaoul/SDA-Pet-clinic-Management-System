package com.sda.raoul.petclinic.repository;

import com.sda.raoul.petclinic.model.Client;
import com.sda.raoul.petclinic.repository.base.BaseRepository;

import java.util.Optional;

public interface ClientRepository extends BaseRepository<Client,Long> {
    Optional<Client> findByFirstNameAndLastName(String firstName,String lastName);
}
