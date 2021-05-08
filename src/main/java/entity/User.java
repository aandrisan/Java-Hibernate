package entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String iduser;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
	private String parola;

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String name) {
		this.name = name;
	}
	
	public User() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
