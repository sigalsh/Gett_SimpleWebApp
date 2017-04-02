package simplewebapp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "drivers")
public class Driver  implements Serializable {

	private static final long serialVersionUID = -1304397377238054237L;
	
	@Id
	@Column(name = "id")
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "licenseNumber")
	String licenseNumber;
	
	public Driver(int id, String name, String licenseNumber) {
		super();
		this.id = id;
		this.name = name;
		this.licenseNumber = licenseNumber;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLicenseNumber() {
		return licenseNumber;
	}
	
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	
	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", licenseNumber=" + licenseNumber + "]";
	}


}
