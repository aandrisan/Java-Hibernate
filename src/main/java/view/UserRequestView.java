package view;

import controller.UserRequestController;

import javax.swing.*;

public class UserRequestView {

    private UserRequestController userRequest;
    private JFrame view = new JFrame();
    private JTable table;
    public UserRequestView(UserRequestController controller){
        userRequest = controller;
        String[] columns = new String[] {"Number","User Residece",
                "Document type", "Date", "Status","Desctiption"
        };

        //actual data for the table in a 2d array
        Object[][] data = userRequest.getRequests();
        //create table with data
        table = new JTable(data, columns);
        table.setEnabled(false);
        view.add(new JScrollPane(table));
        drawLoginView();

    }

    private void drawLoginView() {
        view.setTitle("Requests");
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.pack();
        view.setVisible(true);
    }
}
