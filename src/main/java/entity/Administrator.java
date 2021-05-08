package entity;
import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Administrator {

    @Id
    private String idadmin;

    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String parola;

    public Administrator(){}

    public String getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(String idadmin) {
        this.idadmin = idadmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}
