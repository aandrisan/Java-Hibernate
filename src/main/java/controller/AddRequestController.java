package controller;

import dto.RequestAdminDto;
import dto.RequestUserDto;
import dto.UserDto;
import entity.Document;
import entity.Residence;
import service.DocumentService;
import service.RequestService;
import service.ResidenceService;
import utils.AplicationUtils;
import view.AddRequestView;

import javax.swing.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AddRequestController {
    private final RequestService requestService = new RequestService();
    private final DocumentService documentService = new DocumentService();
    private final ResidenceService residenceService = new ResidenceService();
    private UserDto userDto;

    public AddRequestController(UserDto user) {
        userDto = user;
        new AddRequestView(this);
    }

    public Object[][] getRequests() {
        List<Document> documents = documentService.getAllDocuments();
        List<Residence> residences = residenceService.getResidenceOfUser(userDto.getId());
        int j = documents.size();
        int k = residences.size();
        int max = Integer.max(j, k);
        Object[][] requests = new Object[max][2];
        int i = 0;
        for (Document d : documents) {
            requests[i][0] = d.getName();
            i++;
        }
        i = 0;
        for (Residence r : residences) {
            requests[i][1] = r.getLocation();
            i++;
        }

        return requests;
    }

    public void addRequest(String residence, String document, String description) {
        if(testDesctiption(description) && testDocument(document) && testResidence(residence)){
            Residence residence1 = residenceService.getResidenceByLocation(residence,userDto.getId());
            Document document1 = documentService.getDocumentOfName(document);
            List<RequestUserDto> requestUserDtos = requestService.getRequestsOfUserResidence(
                    userDto.getId(), document1.getIddocument(),residence1.getIdresidence());
            String dataInceputAn = new String("01 01 2021 00:00");
            int i = 0;
            for(RequestUserDto r : requestUserDtos){
                try {
                    Date data1 = AplicationUtils.generateDateFromString(r.getDate());
                    Date data2 = AplicationUtils.generateDateFromString(dataInceputAn);
                    if(data2.before(data1)){
                        i++;
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Data problems", "Wrong description",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }

            if(i>=3){
                JOptionPane.showMessageDialog(null, "Request limit", "Request",
                        JOptionPane.INFORMATION_MESSAGE);
            }else{
                RequestUserDto newRequest = new RequestUserDto();
                newRequest.setIdRequest(UUID.randomUUID().toString());
                newRequest.setDescription(description);
                newRequest.setDocument(document1.getIddocument());
                newRequest.setResidence(residence1.getIdresidence());
                newRequest.setStatus("sent");

                requestService.insertRequest(newRequest, userDto.getId());
            }
        }
    }

    public boolean testDesctiption(String desription){
        if(!desription.equals("")){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Description is empty", "Wrong description",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public boolean testResidence(String residenceName) {
        if (!residenceName.equals("")) {

                if (residenceService.getResidenceByLocation(residenceName,userDto.getId()) != null ){
                    return true;
                }
            JOptionPane.showMessageDialog(null, "Residence dosen't exists", "Wrong residence",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Complete residence field", "Wrong residence",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public boolean testDocument(String document) {
        if (!document.equals("")) {
            List<Document> documents = documentService.getAllDocuments();
            for (Document d : documents) {
                if (document.equals(d.getName())) {
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null, "Document dosen't exists", "Wrong document",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else{
        JOptionPane.showMessageDialog(null, "Document field if empty", "Wrong document",
                JOptionPane.INFORMATION_MESSAGE);
        return false;
        }
    }
}
