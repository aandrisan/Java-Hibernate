package service;


import dto.AdministratorDto;
import entity.Administrator;
import repository.AdministratorRepo;
import validators.AdministratorValidator;

public class AdministratorService {
    private final AdministratorRepo admin = new AdministratorRepo();

    public AdministratorDto getByEmailUser(String email){
        AdministratorValidator.validateGetAdminByEmail(email);
        Administrator administrator = admin.findByEmail(email);
        AdministratorDto adminDto = new AdministratorDto();
        adminDto.setId(administrator.getIdadmin());
        adminDto.setName(administrator.getName());
        return adminDto;
    }
}
