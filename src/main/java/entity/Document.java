package entity;

import javax.persistence.*;

@Entity
@Table(name = "document")
public class Document {

    @Id
    private String iddocument;

    @Column(nullable = false, unique = true)
    private String name;

    public Document() {}

    public String getIddocument() {
        return iddocument;
    }

    public void setIddocument(String iddocument) {
        this.iddocument = iddocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}