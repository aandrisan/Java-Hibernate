package view;

import controller.AddDeleteDocumentController;

import javax.swing.*;

public class AddDeleteDocumentView {
    private AddDeleteDocumentController addDeleteDocumentController;

    private JFrame view;
    private JTable table;
    private JPanel panel;
    private JLabel lable = new JLabel("Insert name of the document");
    private JTextField documentName= new JTextField(20);
    private JButton insertDocumentButton = new JButton("Insert");
    private JButton deteleDocumentButton = new JButton("Delete");
    public AddDeleteDocumentView(AddDeleteDocumentController controller){
        addDeleteDocumentController=controller;
        panel = new JPanel();
        view = new JFrame();

        String[] columns = new String[] {"Name"};

        Object[][] data = addDeleteDocumentController.getDocument();
        //create table with data
        table = new JTable(data, columns);
        table.setEnabled(false);
        panel.add(new JScrollPane(table));

        insertDocumentButton.addActionListener(e->{
            addDeleteDocumentController.addDocument(documentName.getText());
        });

        deteleDocumentButton.addActionListener(e->{
            addDeleteDocumentController.deleteDocument(documentName.getText());
        });

        addComponentToFrame();
        view.add(panel);
        drawLoginView();

    }



    public void addComponentToFrame(){
        panel.add(lable);
        panel.add(documentName);
        panel.add(insertDocumentButton);
        panel.add(deteleDocumentButton);
    }

    private void drawLoginView() {
        view.setTitle("Add/Delete Document");
        view.setSize(450, 300);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.pack();
        view.setVisible(true);
    }
}
