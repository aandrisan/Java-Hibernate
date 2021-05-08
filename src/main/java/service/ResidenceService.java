package service;

import entity.Residence;
import repository.ResidenceRepo;
import validators.GenericValidator;

import java.util.List;
import java.util.UUID;

public class ResidenceService {

    private final ResidenceRepo residenceRepo = new ResidenceRepo();

    public List<Residence> getResidenceOfUser(String id){
        GenericValidator.validateGeneric(id);
        return residenceRepo.findAllResidenceOfUser(id);
    }

    public Residence getResidenceByLocation(String location, String idUser){
        GenericValidator.validateGeneric(location);
        GenericValidator.validateGeneric(idUser);
        return residenceRepo.findResidenceByLocation(location,idUser);
    }

    public void addResidence(String idUser, String location){
        GenericValidator.validateGeneric(idUser);
        GenericValidator.validateGeneric(location);
        Residence residence = new Residence();
        residence.setOwner(idUser);
        residence.setLocation(location);
        residence.setIdresidence(UUID.randomUUID().toString());
        residenceRepo.insertNewResidnce(residence);
    }

    public void deleteResidence (Residence residence){
        GenericValidator.validateGeneric(residence.getIdresidence());
        residenceRepo.deleteResidence(residence);
    }
}
