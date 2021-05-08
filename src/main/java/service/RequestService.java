package service;

import dto.RequestAdminDto;
import dto.RequestUserDto;
import entity.Document;
import entity.Request;
import entity.Residence;
import entity.User;
import repository.DocumentRepo;
import repository.RequestRepo;
import repository.ResidenceRepo;
import repository.UserRepo;
import utils.AplicationUtils;
import validators.RequestValidator;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestService {

    private final UserRepo userRepo = new UserRepo();
    private final DocumentRepo documentRepo = new DocumentRepo();
    private final ResidenceRepo residenceRepo = new ResidenceRepo();
    private final RequestRepo requestRepo = new RequestRepo();

    public List<RequestAdminDto> getAllRequests(){
        ArrayList<RequestAdminDto> requestAdminDto = new ArrayList<RequestAdminDto>();
        List<Request> requests = requestRepo.findAllRequests();
        for(Request r : requests){
            requestAdminDto.add(createRequestForAdmin(r));
        }
        return requestAdminDto;
    }

    public List<RequestUserDto> getAllUserRequest(String id){
        ArrayList<RequestUserDto> requestUserDtos = new ArrayList<RequestUserDto>();
        List<Request> requests = requestRepo.findRequestsOfUser(id);
        for(Request r : requests){
            requestUserDtos.add(createRequestForUser(r));
        }
        return requestUserDtos;
    }

    public List<RequestUserDto> getRequestsOfUserResidence(String id, String idDoc, String idRes){
        ArrayList<RequestUserDto> requestUserDtos = new ArrayList<>();
        List<Request> requests = requestRepo.findRequestsOfUserResidence(id,idDoc,idRes);
        for(Request r : requests){
            requestUserDtos.add(createRequestForUser(r));
        }
        return requestUserDtos;

    }

    public void insertRequest(RequestUserDto requestUserDto,String idUser){
        Request request = new Request();
        request.setDescription(requestUserDto.getDescription());
        request.setDocument(requestUserDto.getDocument());
        request.setStatus(requestUserDto.getStatus());
        request.setResidence(requestUserDto.getResidence());
        request.setIdrequest(requestUserDto.getIdRequest());
        request.setOwner(idUser);
        request.setData(Date.from(Instant.now()));

        requestRepo.insertNewRequest(request);

    }

    public void updateRequestStatus(String id, String status){
        RequestValidator.validateStatus(id);
        RequestAdminDto request = new RequestAdminDto();
        request.setIdRequest(id);
        request.setStatus(status);
        requestRepo.updateRequest(request);
    }

    private RequestAdminDto createRequestForAdmin(Request r){
        User user = userRepo.findByIdUser(r.getOwner());
        Document document = documentRepo.findDocumentById(r.getDocument());
        Residence residence = residenceRepo.findResidenceById(r.getResidence());
        String date = AplicationUtils.generatePrettyDateFromSQLDate(r.getData());

        RequestAdminDto requestAdminDto = new RequestAdminDto();
        requestAdminDto.setDate(date);
        requestAdminDto.setIdRequest(r.getIdrequest());
        requestAdminDto.setStatus(r.getStatus());
        if(residence == null){
            requestAdminDto.setResidence(null);
        }else{
            requestAdminDto.setResidence(residence.getLocation());
        }

        if(user == null){
            requestAdminDto.setUserName(null);
        }else{
            requestAdminDto.setUserName(user.getName());
        }

        if(document==null){
            requestAdminDto.setTipDocument(null);
        }else{
            requestAdminDto.setTipDocument(document.getName());
        }

        return requestAdminDto;
    }

    private RequestUserDto createRequestForUser (Request r){
        Document document = documentRepo.findDocumentById(r.getDocument());
        Residence residence = residenceRepo.findResidenceById(r.getResidence());
        String date = AplicationUtils.generatePrettyDateFromSQLDate(r.getData());

        RequestUserDto requestUserDto = new RequestUserDto();
        requestUserDto.setDate(date);
        requestUserDto.setIdRequest(r.getIdrequest());
        requestUserDto.setStatus(r.getStatus());
        requestUserDto.setDescription(r.getDescription());
        if(residence == null){
            requestUserDto.setResidence(null);
        }else{
            requestUserDto.setResidence(residence.getLocation());
        }

        if(document==null){
            requestUserDto.setDocument(null);
        }else{
            requestUserDto.setDocument(document.getName());
        }

        return requestUserDto;
    }

    public void deleteRequest(String id){
        RequestUserDto requestUserDto = new RequestUserDto();
        requestUserDto.setIdRequest(id);
        RequestValidator.validateRequest(requestUserDto,requestRepo.findAllRequests());
        requestRepo.removeRequest(requestUserDto);
    }

    public void updateDesctiptionRequest(String id, String description){
        RequestValidator.validateStatus(id);
        RequestUserDto request = new RequestUserDto();
        request.setIdRequest(id);
        request.setDescription(description);
        requestRepo.updateRequestDescription(request);
    }
}
