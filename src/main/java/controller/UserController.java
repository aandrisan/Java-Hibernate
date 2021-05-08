package controller;

import dto.UserDto;
import view.AddRemoveResidenceView;
import view.AddUpdateDelReqView;
import view.UserView;

public class UserController {

    private UserDto userDto;
    public UserController(UserDto user){
        userDto = user;
        new UserView(this);

    }

    public String getUserName(){
        return userDto.getName();
    }

    public void addRemoveResidenceUser(){
        new AddRemoveResidenceController(userDto);
    }

    public void viewRequestOfUser(){
        new UserRequestController(userDto);
    }

    public void addUpdateDeleteRequest(){
        new AddUpdateDelReqController(userDto);
    }

}
