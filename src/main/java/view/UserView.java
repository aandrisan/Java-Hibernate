package view;

import controller.UserController;

import javax.swing.*;

public class UserView {
    private UserController userController;
    private JFrame view = new JFrame();
    private JLabel dateUser;
    private JButton addResidance  = new JButton("Add/Remove Residence");
    private JButton viewRequest = new JButton("View Requests");
    private JButton addUpdateDeleteRequest = new JButton("Add/Update/Delete Request");

    public UserView(UserController controller){
        userController=controller;
        dateUser = new JLabel("Welcome, "+userController.getUserName());

        addResidance.addActionListener(e->{
            userController.addRemoveResidenceUser();
        });

        viewRequest.addActionListener(e->{
            userController.viewRequestOfUser();
        });

        addUpdateDeleteRequest.addActionListener(e->{

            userController.addUpdateDeleteRequest();
        });

        addComponentToFrame();
        setBoundsForObjects();
        drawLoginView();

    }

    public void addComponentToFrame(){
        view.add(dateUser);
        view.add(addResidance);
        view.add(viewRequest);
        view.add(addUpdateDeleteRequest);
    }

    public void setBoundsForObjects(){
        dateUser.setBounds(154,2,220,15);
        viewRequest.setBounds(154,32,220,20);
        addUpdateDeleteRequest.setBounds(154,62,220,20);
        addResidance.setBounds(154,92,220,20);
    }

    private void drawLoginView() {
        view.setTitle("User");
        view.setSize(550, 300);
        view.setLayout(null);// using no layout managers
        view.setVisible(true);// making the frame visible
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
