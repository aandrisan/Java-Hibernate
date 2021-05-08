package controller;

import entity.Document;
import service.DocumentService;
import view.AddDeleteDocumentView;

import javax.swing.*;
import java.util.List;

public class AddDeleteDocumentController {
    private DocumentService docSer;

    public AddDeleteDocumentController(){
        docSer = new DocumentService();
        new AddDeleteDocumentView(this);
    }

    public Object[][] getDocument(){

        List<Document> documents = docSer.getAllDocuments();
        int j = documents.size();
        Object[][] documentsNames = new Object[j][1];
        int i =0;
        for(Document d : documents){
            documentsNames[i][0]=d.getName();
            i++;
        }
        return documentsNames;
    }

    public void addDocument(String name) {
        try {
            if (name != null || !name.equals("")) {
                List<Document> documents = docSer.getAllDocuments();
                boolean ok = false;
                for(Document d : documents){
                    if(d.getName().equals(name)){
                        ok = true;
                    }
                }
                if(ok){
                    JOptionPane.showMessageDialog(null, "Document exists", "Field is wrong",
                            JOptionPane.INFORMATION_MESSAGE);
                }else{
                    docSer.addDocument(name);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Field is empty", "Field is empty",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Field is empty", "Field is empty",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void deleteDocument(String name){
        try {
            if (name != null || !name.equals("")) {
                List<Document> documents = docSer.getAllDocuments();
                boolean ok = false;
                for(Document d : documents){
                    if(d.getName().equals(name)){
                        docSer.deleteDocument(d);
                        ok = true;
                    }
                }
                if(ok == false){
                    JOptionPane.showMessageDialog(null, "Document name is wrong", "Field is wrong",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Field is empty", "Field is empty",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Field is empty", "Field is empty",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
