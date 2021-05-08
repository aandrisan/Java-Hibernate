package controller;

import service.UserService;
import view.UserSignUpView;

import javax.swing.*;

public class UserSignUpController {
    private UserService userService;
    public UserSignUpController(){
        userService = new UserService();
        new UserSignUpView(this);

    }

    public void createNewUser(String name, String email, String password){
        try{
        if(!name.equals("") && !email.equals("") && !password.equals("") ){
            userService.inserUser(name,email,password);
        }else{
            JOptionPane.showMessageDialog(null, "Field is empty", "Field is empty",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Field is empty", "Field is empty",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
