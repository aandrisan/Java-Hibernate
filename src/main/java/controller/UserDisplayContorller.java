package controller;

import dto.UserDto;
import service.UserService;
import view.UserDisplayView;

import java.util.List;

public class UserDisplayContorller {

    private UserService userService;
    private UserDisplayView view;
    public UserDisplayContorller(){
        userService = new UserService();
        view = new UserDisplayView(this);
    }

    public Object[][] getUsers(){

        List<UserDto> usersDto = userService.getAllUsers();
        int j = usersDto.size();
        Object[][] users = new Object[j][2];
        int i =0;
        for(UserDto u : usersDto){
            System.err.println(u.getName() + "De ce dai null");
            users[i][0]=u.getName();
            users[i][1]=u.getEmail();
            i++;
        }
        return users;
    }
}
