package controller;

import dto.RequestAdminDto;
import service.RequestService;
import view.ApproveDeleteRequestView;

import javax.swing.*;
import java.util.List;

public class ApproveDeleteRequestController {
    private RequestService requestService;
    public ApproveDeleteRequestController(){
        requestService = new RequestService();
        new ApproveDeleteRequestView(this);
    }

    public Object[][] getRequests(){

        List<RequestAdminDto> requestDto = requestService.getAllRequests();
        int j = 0;
        for(RequestAdminDto r : requestDto){
            if(r.getStatus().equals("sent")){
                j++;
            }
        }
        Object[][] requests = new Object[j][7];
        int i =0;
        for(RequestAdminDto r : requestDto){
            if(r.getStatus().equals("sent")) {
                requests[i][0] = (i + 1);
                requests[i][1] = r.getUserName();
                requests[i][2] = r.getResidence();
                requests[i][3] = r.getTipDocument();
                requests[i][4] = r.getDate();
                requests[i][5] = r.getStatus();
                requests[i][6] = r.getIdRequest();
                i++;
            }
        }
        return requests;
    }

    public void approveRequest(String idRequest){
        requestService.updateRequestStatus(idRequest, "approved");
    }

    public void deleteRequest(String idRequest){
        requestService.updateRequestStatus(idRequest,"disapproved");
    }

    public boolean testIndex(int index, int size){
        if(index > size || index < 1){
            JOptionPane.showMessageDialog(null, "Index out of range", "Wrong index",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
}
