package service;

import entity.Document;
import repository.DocumentRepo;
import validators.DcoumentValidator;
import validators.GenericValidator;

import java.util.List;
import java.util.UUID;

public class DocumentService {

    private final DocumentRepo docRep = new DocumentRepo();
    public List<Document> getAllDocuments(){
        return docRep.findAllDocument();
    }

    public Document getDocumentOfName(String name){
        GenericValidator.validateGeneric(name);
        return docRep.findDocumentByName(name);
    }

    public void addDocument(String documentName){
        DcoumentValidator.validateDocuemntName(documentName);
        Document document = new Document();
        document.setName(documentName);
        document.setIddocument(UUID.randomUUID().toString());
        docRep.insertNewDocument(document);
    }

    public void deleteDocument(Document documentName){
        DcoumentValidator.validateDocuemntName(documentName.getName());
        docRep.deleteDcoument(documentName);
    }
}
