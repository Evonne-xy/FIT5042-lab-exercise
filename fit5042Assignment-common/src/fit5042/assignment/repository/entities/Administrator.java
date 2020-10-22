package fit5042.assignment.repository.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Administrator")
@NamedQueries({
    @NamedQuery(name = Administrator.GET_ALL_QUERY_NAME, query = "SELECT a FROM Administrator a order by a.adminId desc")})
public class Administrator implements Serializable{

	public static final String GET_ALL_QUERY_NAME = "Administrator.getAll";
	
	@Id
    @GeneratedValue
    private int adminId;
    private String adminFirstName;
    private String adminLastName;
    private String userName;

    public Administrator() {
    }

	

	public Administrator(int adminId, String adminFirstName, String adminLastName, String userName) {
		super();
		this.adminId = adminId;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.userName = userName;
	}



	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}


	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}  


	



}