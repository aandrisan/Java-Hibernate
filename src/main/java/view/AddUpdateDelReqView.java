package view;

import controller.AddUpdateDelReqController;

import javax.swing.*;
import java.awt.*;

public class AddUpdateDelReqView {
    private AddUpdateDelReqController addUpdateDelReq;
    private JFrame view;
    private JTable table;
    private JPanel panel;
    private JLabel lable = new JLabel("Insert number of request");
    private JLabel label1 = new JLabel("Insert new description");
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    //private JLabel
    private JTextField requestNumber= new JTextField(20);
    private JTextField requestDesctiption = new JTextField(30);
    private JButton insertDocumentButton = new JButton("Add");
    private JButton deteleDocumentButton = new JButton("Delete");
    private JButton updateRequestButton = new JButton("Update");

    public AddUpdateDelReqView(AddUpdateDelReqController controller){
        addUpdateDelReq = controller;

        panel = new JPanel(new GridLayout(0,1));

        view = new JFrame();
        String[] columns = new String[] {"Number","User Residece",
                "Document type", "Date", "Status","Desctiption"
        };

        Object[][] data = addUpdateDelReq.getRequests();

        deteleDocumentButton.addActionListener(e->{
            if(addUpdateDelReq.testIndex(Integer.parseInt(requestNumber.getText()),data.length)){
                addUpdateDelReq.deteleRequestOfUser((String)data[Integer.parseInt(requestNumber.getText())-1][6]
                        ,(String)data[Integer.parseInt(requestNumber.getText())-1][4]);
            }
        });

        updateRequestButton.addActionListener(e->{
            if(addUpdateDelReq.testIndex(Integer.parseInt(requestNumber.getText()),data.length)){
                addUpdateDelReq.updateRequestDescription((String)data[Integer.parseInt(requestNumber.getText())-1][6],
                        requestDesctiption.getText(),(String)data[Integer.parseInt(requestNumber.getText())-1][4]);
            }
        });

        insertDocumentButton.addActionListener(e->{
            addUpdateDelReq.addRequest();
        });

        table = new JTable(data, columns);
        table.setEnabled(false);
        panel.add(new JScrollPane(table));
        addComponentToFrame();
        view.add(panel);
        drawLoginView();
    }



    public void addComponentToFrame(){
        panel2.add(lable);
        panel2.add(requestNumber);
        panel.add(panel2);
        panel3.add(label1);
        panel3.add(requestDesctiption);
        panel.add(panel3);
        panel4.add(insertDocumentButton);
        panel4.add(deteleDocumentButton);
        panel4.add(updateRequestButton);
        panel.add(panel4);
    }

    private void drawLoginView() {
        view.setTitle("Add/Update/Delete Request");
        view.setSize(450, 300);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.pack();
        view.setVisible(true);
    }
}
