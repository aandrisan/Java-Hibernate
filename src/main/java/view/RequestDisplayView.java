package view;

import controller.RequestDispayController;

import javax.swing.*;

public class RequestDisplayView {
    private RequestDispayController requestDispayController;
    private JFrame view;
    private JTable table;
    public RequestDisplayView(RequestDispayController req){
        requestDispayController= req;
        view = new JFrame();
        String[] columns = new String[] {"Number","User Name","User Residece",
                "Document type", "Date", "status"
        };

        //actual data for the table in a 2d array
        Object[][] data = requestDispayController.getRequests();
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
