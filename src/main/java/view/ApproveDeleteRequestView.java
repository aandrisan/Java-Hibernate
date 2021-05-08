package view;

import controller.ApproveDeleteRequestController;

import javax.swing.*;

public class ApproveDeleteRequestView {
    private ApproveDeleteRequestController approveDeleteRequest;

    private JFrame view;
    private JTable table;
    private JPanel panel;
    private JLabel lable = new JLabel("Insert number of the request");
    private JTextField documentName= new JTextField(20);
    private JButton approveRequestButton = new JButton("Approve");
    private JButton deteleRequestButton = new JButton("Disapprove");

    public ApproveDeleteRequestView(ApproveDeleteRequestController controller){
        approveDeleteRequest = controller;

        panel = new JPanel();
        view = new JFrame();
        String[] columns = new String[] {"Number","User Name","User Residece",
                "Document type", "Date", "status"
        };

        Object[][] data = approveDeleteRequest.getRequests();
        table = new JTable(data, columns);
        table.setEnabled(false);
        panel.add(new JScrollPane(table));

        approveRequestButton.addActionListener(e->{
            if(approveDeleteRequest.testIndex(Integer.parseInt(documentName.getText()), data.length))
            {
                approveDeleteRequest.approveRequest((String)data[Integer.parseInt(documentName.getText())-1][6]);
            }

        });

        deteleRequestButton.addActionListener(e->{
            if(approveDeleteRequest.testIndex(Integer.parseInt(documentName.getText()), data.length))
            {
                approveDeleteRequest.deleteRequest((String)data[Integer.parseInt(documentName.getText())-1][6]);
            }
        });

        addComponentToFrame();
        view.add(panel);
        drawLoginView();
    }

    public void addComponentToFrame(){
        //panel.add(new JScrollPane(table));
        panel.add(lable);
        panel.add(documentName);
        panel.add(approveRequestButton);
        panel.add(deteleRequestButton);
    }

    private void drawLoginView() {
        view.setTitle("Approve/Delete Requests");
        view.setSize(450, 300);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.pack();
        view.setVisible(true);
} }
