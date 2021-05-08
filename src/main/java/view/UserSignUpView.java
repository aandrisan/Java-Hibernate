package view;

import controller.UserSignUpController;

import javax.swing.*;

public class UserSignUpView {

    private UserSignUpController userSignUpController;

    JTextField name = new JTextField();
    JLabel label1 = new JLabel("Name:");
    JTextField email = new JTextField();
    JLabel label2 = new JLabel("Email:");
    JPasswordField password = new JPasswordField();
    JLabel label3 = new JLabel("Password:");
    JButton create = new JButton("Create acount");
    JFrame view = new JFrame();
    public UserSignUpView(UserSignUpController controller){
        userSignUpController = controller;

        create.addActionListener(e->{
            userSignUpController.createNewUser(name.getText(),email.getText(),password.getText());
        });

        addComponentToFrame();
        setBoundsForObjects();
        drawLoginView();
    }

    void setBoundsForObjects(){
        name.setBounds(100,2,100,20);
        label1.setBounds(10,2,80,15);
        email.setBounds(100,32,100,20);
        label2.setBounds(10,32,80,15);
        password.setBounds(100,62,100,20);
        label3.setBounds(10,62,80,15);
        create.setBounds(10,92,200,20);

    }

    void addComponentToFrame(){
        view.add(name);
        view.add(label1);
        view.add(email);
        view.add(label2);
        view.add(password);
        view.add(label3);
        view.add(create);
    }

    private void drawLoginView() {
        view.setTitle("Sign Up");
        view.setSize(450, 300);
        view.setLayout(null);// using no layout managers
        view.setVisible(true);// making the frame visible
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
