package controller;

import dto.RequestUserDto;
import dto.UserDto;
import service.RequestService;
import view.AddUpdateDelReqView;

import javax.swing.*;
import java.util.List;

public class AddUpdateDelReqController {
    private RequestService requestService;
    private UserDto userDto;

    public AddUpdateDelReqController(UserDto user) {
        requestService = new RequestService();
        userDto = user;
        new AddUpdateDelReqView(this);
    }

    public Object[][] getRequests(){

        List<RequestUserDto> requestDto = requestService.getAllUserRequest(userDto.getId());
        int j = requestDto.size();
        System.err.println("Cate request imi gaseste "+j);
        Object[][] requests = new Object[j][7];
        int i =0;
        for(RequestUserDto r : requestDto){
            requests[i][0] = (i+1);
            requests[i][1] = r.getResidence();
            requests[i][2] = r.getDocument();
            requests[i][3] = r.getDate();
            requests[i][4] = r.getStatus();
            requests[i][5] = r.getDescription();
            requests[i][6] = r.getIdRequest();
            i++;
        }
        return requests;
    }

    public boolean testIndex(int index, int size){
        if(index > size || index < 1){
            JOptionPane.showMessageDialog(null, "Index out of range", "Wrong index",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    public void deteleRequestOfUser(String idRequest,String status){
        if(!idRequest.equals("")) {
            if(status.equals("sent")){
                requestService.deleteRequest(idRequest);
            }else{
                JOptionPane.showMessageDialog(null, "Only requests with status = sent", "Wrong status",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Index out of range", "Wrong index",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void updateRequestDescription(String idRequest, String desctiption, String status){
        if(!idRequest.equals("")) {
            if(status.equals("sent")) {
                requestService.updateDesctiptionRequest(idRequest, desctiption);
            }else{
                JOptionPane.showMessageDialog(null, "Only requests with status = sent", "Wrong status",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Index out of range", "Wrong index",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void addRequest() {
        new AddRequestController(userDto);
    }
}
