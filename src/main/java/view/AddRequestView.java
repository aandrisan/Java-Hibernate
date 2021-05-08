package view;

import controller.AddRequestController;

import javax.swing.*;
import java.awt.*;

public class AddRequestView {
    private final AddRequestController addRequestController;

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();

    private JLabel label1 = new JLabel("Residence: ");
    private JLabel label2 = new JLabel("Type of document:");
    private JLabel label3 = new JLabel("Description of request:");

    private JTextField residence = new JTextField(30);
    private JTextField document = new JTextField(30);
    private JTextField description = new JTextField(30);

    private JButton addRequestButton = new JButton("Add request");

    private JTable table;
    private JFrame view;

    public AddRequestView(AddRequestController controller){
        addRequestController = controller;

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(0,1));
        view = new JFrame();

        String[] columns = new String[] {"Document type","Residences"
        };

        Object[][] data = addRequestController.getRequests();
        table = new JTable(data, columns);
        table.setEnabled(false);
        panel1.add(new JScrollPane(table));

        addRequestButton.addActionListener(e->{
            addRequestController.addRequest(residence.getText(),
                    document.getText(),description.getText());
        });
        addComponentToFrame();
        view.add(panel1);
        drawLoginView();
    }

    private void addComponentToFrame(){
        panel2.add(label1);
        panel2.add(residence);
        panel1.add(panel2);
        panel3.add(label2);
        panel3.add(document);
        panel1.add(panel3);
        panel4.add(label3);
        panel4.add(description);
        panel5.add(addRequestButton);
        panel1.add(panel4);
        panel1.add(panel5);
    }

    private void drawLoginView() {
        view.setTitle("Add Request");
        view.setSize(450, 300);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.pack();
        view.setVisible(true);
    }
}
