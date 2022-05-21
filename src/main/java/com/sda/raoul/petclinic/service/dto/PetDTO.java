package com.sda.raoul.petclinic.service.dto;

import com.sda.raoul.petclinic.model.Client;
import com.sda.raoul.petclinic.model.Consult;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class PetDTO {

    private Long id;
    private String race;
    private Date birthDate;
    private Boolean isVaccinated;
    private String ownerName;

    public PetDTO() {
    }

    public PetDTO(Long id, String race, Date birthDate, Boolean isVaccinated, String ownerName) {
        this.id = id;
        this.race = race;
        this.birthDate = birthDate;
        this.isVaccinated = isVaccinated;
        this.ownerName = ownerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "PetDTO{" +
                "id=" + id +
                ", race='" + race + '\'' +
                ", birthDate=" + birthDate +
                ", isVaccinated=" + isVaccinated +
                '}';
    }
}
