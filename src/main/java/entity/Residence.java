package entity;

import javax.persistence.*;

@Entity
@Table(name = "residence")
public class Residence {

    @Id
    private String idresidence;

    @Column(nullable = false)
    private String owner;
    @Column(nullable = false,unique = true)
    private String location;

    public Residence() {}

    public String getIdresidence() {
        return idresidence;
    }

    public void setIdresidence(String idresidence) {
        this.idresidence = idresidence;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

