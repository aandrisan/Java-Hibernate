package view;

import controller.AddDeleteDocumentController;
import controller.AddRemoveResidenceController;

import javax.swing.*;

public class AddRemoveResidenceView {

    private AddRemoveResidenceController addRemoveResidence;
    private JFrame view = new JFrame();
    private JTable table;
    private JPanel panel = new JPanel();
    private JLabel lable = new JLabel("Insert location of the residence");
    private JTextField residenceLocation= new JTextField(30);
    private JButton insertResidenceButton = new JButton("Add");
    private JButton deteleResidenceButton = new JButton("Delete");

    public AddRemoveResidenceView(AddRemoveResidenceController controller){
        addRemoveResidence = controller;
        String[] columns = new String[] {"Location"
        };

        Object[][] data = addRemoveResidence.getResidences();

        table = new JTable(data, columns);
        table.setEnabled(false);
        panel.add(new JScrollPane(table));

        insertResidenceButton.addActionListener(e->{
            addRemoveResidence.addResidence(residenceLocation.getText());
        });

        deteleResidenceButton.addActionListener(e->{
            addRemoveResidence.deleteResidence(residenceLocation.getText());
        });

        addComponentToFrame();
        view.add(panel);
        drawLoginView();
    }

    public void addComponentToFrame(){
        //panel.add(new JScrollPane(table));
        panel.add(lable);
        panel.add(residenceLocation);
        panel.add(insertResidenceButton);
        panel.add(deteleResidenceButton);
    }

    private void drawLoginView() {
        view.setTitle("Add/Remove Residence");
        view.setSize(450, 300);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.pack();
        view.setVisible(true);
    }
}
