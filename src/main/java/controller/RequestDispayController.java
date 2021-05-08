package controller;

import dto.RequestAdminDto;
import dto.UserDto;
import service.RequestService;
import view.RequestDisplayView;

import java.util.List;

public class RequestDispayController {
    private RequestService requestService;
    public RequestDispayController(){
        requestService = new RequestService();
        new RequestDisplayView(this);

    }

    public Object[][] getRequests(){

        List<RequestAdminDto> requestDto = requestService.getAllRequests();
        int j = requestDto.size();
        Object[][] requests = new Object[j][6];
        int i =0;
        for(RequestAdminDto r : requestDto){
            requests[i][0] = (i+1);
            requests[i][1] = r.getUserName();
            requests[i][2] = r.getResidence();
            requests[i][3] = r.getTipDocument();
            requests[i][4] = r.getDate();
            requests[i][5] = r.getStatus();
            i++;
        }
        return requests;
    }
}
