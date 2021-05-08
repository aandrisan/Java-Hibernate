package view;

import controller.UserDisplayContorller;
import dto.UserDto;
import entity.User;

import javax.swing.*;



public class UserDisplayView {
    private UserDisplayContorller userDisplayContorller;
    private JFrame view;
    private JTable table;


    public UserDisplayView(UserDisplayContorller user){
        userDisplayContorller=user;
        view = new JFrame();
        String[] columns = new String[] {"Name","Email"};

        //actual data for the table in a 2d array
        Object[][] data = user.getUsers();
        //create table with data
        table = new JTable(data, columns);
        table.setEnabled(false);
        view.add(new JScrollPane(table));
        drawLoginView();

    }

    private void drawLoginView() {
        view.setTitle("Users");
        view.setSize(450, 300);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.pack();
        view.setVisible(true);
    }
}
