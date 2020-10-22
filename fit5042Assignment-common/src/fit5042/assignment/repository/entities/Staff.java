package fit5042.assignment.repository.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Staff")
@NamedQueries({
    @NamedQuery(name = Staff.GET_ALL_QUERY_NAME, query = "SELECT s FROM Staff s order by s.staffId desc")})
public class Staff implements Serializable{

	public static final String GET_ALL_QUERY_NAME = "Staff.getAll";
	
	@Id
    @GeneratedValue
	private int staffId;
	private String staffName;
	private String userName;
	@Temporal(javax.persistence.TemporalType.DATE)
    private Date dob;
	private Set<Customer> customerMangement;
	
	public Staff() {
		
	}
	
	public Staff(int staffId, String staffName) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
	}
	

	public Staff(int staffId, String staffName, String userName, Date dob, Set<Customer> customerMangement) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.userName = userName;
		this.dob = dob;
		this.customerMangement = new HashSet<>();
	}





	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	@OneToMany (mappedBy = "staff",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	public Set<Customer> getCustomerMangement() {
		return customerMangement;
	}


	public void setCustomerMangement(Set<Customer> customerMangement) {
		this.customerMangement = customerMangement;
	}


	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", dob=" + dob + ", customerMangement="
				+ customerMangement + "]";
	}

	
	
	
	
    
    
}
