package view;

import dto.RegisterDto;
import controller.LoginController;

import javax.swing.*;

public class LoginView {
    private JFrame testView;
    private JTextField emailTextField = new JTextField();
    private JPasswordField passwordTextField= new JPasswordField();
    private JLabel usernameLabel = new JLabel("Email");
    private JButton acountButton = new JButton("Create acount");
    private JLabel passwordLabel = new JLabel("Password");
    private JButton loginButton = new JButton("Login");

    private LoginController testController;

    public LoginView(LoginController controller) {

        testController = controller;
        testView = new JFrame();

        loginButton.addActionListener(e -> {
            RegisterDto dto = new RegisterDto();
            dto.setEmail(emailTextField.getText());
            dto.setPassword(passwordTextField.getText());
            testController.testRegister(dto);
        });
        acountButton.addActionListener(e->{
            testController.accountCreate();
        });

        setBoundsForAllObjects();
        addComponentToFrame();
        drawLoginView();

    }

    public void addComponentToFrame(){
        testView.add(loginButton);
        testView.add(usernameLabel);
        testView.add(emailTextField);
        testView.add(passwordLabel);
        testView.add(passwordTextField);
        testView.add(acountButton);
    }

    public void setBoundsForAllObjects() {
        loginButton.setBounds(201, 143, 75, 23);
        acountButton.setBounds(150,173,136,23);
        passwordTextField.setBounds(114, 109, 162, 20);
        usernameLabel.setBounds(114, 32, 84, 14);
        emailTextField.setBounds(114, 59, 162, 20);
        passwordTextField.setBounds(114, 109, 162, 20);
        usernameLabel.setBounds(114, 32, 84, 14);
        emailTextField.setBounds(114, 59, 162, 20);
        passwordLabel.setBounds(114, 84, 55, 14);
    }


    private void drawLoginView() {
        testView.setTitle("Log in");
        testView.setSize(450, 300);
        testView.setLayout(null);// using no layout managers
        testView.setVisible(true);// making the frame visible
        testView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}