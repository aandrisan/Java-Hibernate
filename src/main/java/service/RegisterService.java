package service;

import dto.RegisterDto;
import entity.Administrator;
import entity.User;
import repository.AdministratorRepo;
import repository.UserRepo;
import validators.AdministratorValidator;
import validators.UserValidator;

public class RegisterService {

    private final UserRepo ur = new UserRepo();
    private final AdministratorRepo admin = new AdministratorRepo();

    public RegisterDto getByEmailUser(String email){
        UserValidator.validateGetUserByEmail(email);
        User user = ur.findByEmail(email);
        if(user == null){
            return null;
        }
        RegisterDto register = new RegisterDto();
        register.setEmail(email);
        register.setPassword(user.getParola());
        return register;
    }

    public RegisterDto getByEmailAdmin(String email){
        AdministratorValidator.validateGetAdminByEmail(email);
        Administrator administrator = admin.findByEmail(email);
        if(administrator == null){
            return null;
        }
        RegisterDto register = new RegisterDto();
        register.setEmail(email);
        register.setPassword(administrator.getParola());
        return register;
    }
}
