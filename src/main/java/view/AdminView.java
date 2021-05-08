package view;

import controller.AdminController;

import javax.swing.*;

public class AdminView extends JFrame {
    private JFrame adminView;
    private JLabel dateAdmin;
    private JButton viewUser = new JButton("View Clients");
    private JButton viewRequest = new JButton("View Request");
    private JButton viewDocument = new JButton("Add/Remove Document");
    private JButton approveDeleteRequest = new JButton("Approve/Delete Request");

    private AdminController adminController;

    public AdminView(AdminController admin){
        adminController = admin;

        adminView = new JFrame();
        dateAdmin= new JLabel("Welcome, "+adminController.genAdminName());

        viewUser.addActionListener(e->{
            adminController.showUsers();
        });

        viewRequest.addActionListener(e->{
            adminController.showRequest();
        });

        viewDocument.addActionListener(e->{
            adminController.addDeleteDocument();
        });

        approveDeleteRequest.addActionListener(e->{
            adminController.approveDeleteRequest();
        });

        addComponentToFrame();
        setBoundsForObjects();
        drawLoginView();

    }

    public void addComponentToFrame(){
        adminView.add(dateAdmin);
        adminView.add(viewRequest);
        adminView.add(viewUser);
        adminView.add(viewDocument);
        adminView.add(approveDeleteRequest);
    }

    public void setBoundsForObjects(){
        dateAdmin.setBounds(154,2,184,14);
        viewUser.setBounds(154,32,184,14);
        viewRequest.setBounds(154,62,184,14);
        viewDocument.setBounds(154,92,184,14);
        approveDeleteRequest.setBounds(154,122,184,14);

    }

    private void drawLoginView() {
        adminView.setTitle("Admin");
        adminView.setSize(450, 300);
        adminView.setLayout(null);// using no layout managers
        adminView.setVisible(true);// making the frame visible
        adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
