package controller;

import dto.AdministratorDto;
import service.AdministratorService;
import view.AdminView;
import view.RequestDisplayView;

public class AdminController {
    private AdministratorDto administratorDto;
    private AdministratorService administratorService;
    private AdminView view;

    public AdminController(AdministratorDto admin){
       administratorDto = admin;
       view = new AdminView(this);
       administratorService = new AdministratorService();
    }

    public void showUsers(){
        new UserDisplayContorller();
    }

    public void showRequest(){

        new RequestDispayController();
    }

    public void addDeleteDocument(){
        new AddDeleteDocumentController();
    }

    public void approveDeleteRequest(){
        new ApproveDeleteRequestController();
    }
    public String genAdminName(){
        return administratorDto.getName();
    }

}
