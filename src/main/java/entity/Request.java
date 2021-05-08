package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request")
public class Request {

    @Id
    private String idrequest;

    @Column(nullable = false)
    private String owner;
    @Column(nullable = false)
    private String residence;
    @Column(nullable = false)
    private String document;

    @Column(nullable = false)
    private Date data;
    @Column(nullable = false)
    private String status;

    @Column
    private String description;

    public Request() { }

    public String getIdrequest() {
        return idrequest;
    }

    public void setIdrequest(String idrequest) {
        this.idrequest = idrequest;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

