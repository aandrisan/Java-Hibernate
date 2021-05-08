package controller;

import dto.UserDto;
import entity.Residence;
import service.ResidenceService;
import view.AddRemoveResidenceView;

import javax.swing.*;
import java.util.List;

public class AddRemoveResidenceController {
    private final ResidenceService residenceService;
    private final UserDto actualUser;
    public AddRemoveResidenceController(UserDto user){
        residenceService = new ResidenceService();
        actualUser = user;
        new AddRemoveResidenceView(this);
    }

    public Object[][] getResidences(){
        List<Residence> residences = residenceService.getResidenceOfUser(actualUser.getId());
        int j = residences.size();
        Object[][] residencesLocation = new Object[j][1];
        int i =0;
        for(Residence r : residences){
            residencesLocation[i][0]=r.getLocation();
            i++;
        }
        return residencesLocation;
    }

    public void addResidence(String location) {
        try {
            if (location != null || !location.equals("")) {
                List<Residence> residences = residenceService.getResidenceOfUser(actualUser.getId());
                boolean ok = false;
                for(Residence r : residences){
                    if(r.getLocation().equals(location)){
                        ok = true;
                    }
                }
                if(ok ){
                    JOptionPane.showMessageDialog(null, "Residence exists", "Field is wrong",
                            JOptionPane.INFORMATION_MESSAGE);
                }else{
                    residenceService.addResidence(actualUser.getId(),location);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Field is empty", "Field is empty",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Field is empty", "Field is empty",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void deleteResidence(String location) {
        try {
            if (location != null || !location.equals("")) {
                List<Residence> residences = residenceService.getResidenceOfUser(actualUser.getId());
                boolean ok = false;
                for(Residence r : residences){
                    if(r.getLocation().equals(location)){
                        ok = true;
                        residenceService.deleteResidence(r);
                    }
                }
                if(!ok ){
                    JOptionPane.showMessageDialog(null, "Residence doesn't exists", "Field is wrong",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Field is empty", "Field is empty",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Field is empty", "Field is empty",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
