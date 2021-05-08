package controller;

import dto.RegisterDto;
import dto.UserDto;
import service.AdministratorService;
import service.RegisterService;
import service.UserService;
import view.LoginView;

import javax.swing.*;

public class LoginController {
    private RegisterService registerService;
    private AdministratorService administratorService;
    private LoginView loginView;
    private UserService userService;

    public LoginController() {
        loginView = new LoginView(this);
        registerService = new RegisterService();
        administratorService = new AdministratorService();
        userService = new UserService();
    }


    public void testRegister(RegisterDto registerDto) {
        System.err.println("Am ajuns sa verific1");
        if (registerDto.getEmail().isEmpty() || registerDto.getEmail().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Field is empty", "Empty field",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.err.println("Am ajuns sa verific2");
            this.testUser(registerDto);
        }
    }

    public void accountCreate(){
        new UserSignUpController();
    }


    public void testUser(RegisterDto registerDto) {
        RegisterDto user = registerService.getByEmailUser(registerDto.getEmail());
        RegisterDto admin = registerService.getByEmailAdmin(registerDto.getEmail());
        System.err.println("Am ajuns sa verific");
        try {
            if (registerDto != null) {
                if (user != null) {
                    if (!user.getEmail().isEmpty()) {
                        if (user.getPassword().equals(registerDto.getPassword())) {
                            //deschide view user
                            UserDto userdto = userService.getByEmailUser(user.getEmail());
                            //System.err.println(userdto.getName() + "Aici e eroarea");
                            new UserController(userdto);
                            // System.err.println("E bun user-ul");
                        } else {
                            System.err.println("E bun user-ul" + user.getPassword());
                            JOptionPane.showMessageDialog(null, "Password is wrong", "Wrong password",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else if (admin != null) {
                    if (!admin.getEmail().isEmpty()) {
                        if (admin.getPassword().equals(registerDto.getPassword())) {
                            new AdminController(administratorService.getByEmailUser(admin.getEmail()));
                        } else {
                            System.err.println("E bun admin-ul" + admin.getPassword());
                            JOptionPane.showMessageDialog(null, "Password is wrong", "Wrong password",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else {
                    System.err.println("User gresit");
                    JOptionPane.showMessageDialog(null, "Password is wrong", "Wrong password",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Password is wrong", "Wrong password",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }
}

