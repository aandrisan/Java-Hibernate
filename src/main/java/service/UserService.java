package service;

import dto.RegisterDto;
import dto.UserDto;
import entity.User;
import repository.UserRepo;
import validators.UserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserService {

    private final UserRepo ur = new UserRepo();

    public void inserUser(String name, String email, String password){
        UserValidator.validateGetUserByEmail(name);
        UserValidator.validateGetUserByEmail(email);
        UserValidator.validateGetUserByEmail(password);
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setParola(password);
        newUser.setIduser(UUID.randomUUID().toString());
        ur.insertNewUser(newUser);

    }
    public UserDto getByEmailUser(String email){
        UserValidator.validateGetUserByEmail(email);
        User user = ur.findByEmail(email);
        UserDto userDto = new UserDto();
        userDto.setId(user.getIduser());
        userDto.setName(user.getName());
        userDto.setEmail(email);
        return userDto;
    }

    public List<UserDto> getAllUsers(){
        List<UserDto> usersDto = new ArrayList<UserDto>();
        List<User> users = ur.getAllUsers();
        for(User u : users){
            usersDto.add(createUserDto(u.getName(),u.getEmail(),u.getIduser()));
        }
        return usersDto;
    }

    public UserDto createUserDto(String nume, String email, String id){
        UserDto user = new UserDto();
        user.setId(id);
        user.setEmail(email);
        user.setName(nume);
        return user;
    }
}
