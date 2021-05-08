package controller;

import dto.RequestAdminDto;
import dto.RequestUserDto;
import dto.UserDto;
import service.RequestService;
import view.UserRequestView;

import java.util.List;

public class UserRequestController {
    private RequestService requestService;
    private UserDto userDto;
    public UserRequestController(UserDto user){
        requestService = new RequestService();
        userDto=user;
        new UserRequestView(this);
    }

    public Object[][] getRequests(){

        List<RequestUserDto> requestDto = requestService.getAllUserRequest(userDto.getId());
        int j = requestDto.size();
        System.err.println("Cate request imi gaseste "+j);
        Object[][] requests = new Object[j][6];
        int i =0;
        for(RequestUserDto r : requestDto){
            requests[i][0] = (i+1);
            requests[i][1] = r.getResidence();
            requests[i][2] = r.getDocument();
            requests[i][3] = r.getDate();
            requests[i][4] = r.getStatus();
            requests[i][5] = r.getDescription();
            i++;
        }
        return requests;
    }
}
