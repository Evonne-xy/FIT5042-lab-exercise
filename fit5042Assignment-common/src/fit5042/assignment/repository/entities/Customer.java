package fit5042.assignment.repository.entities;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "CUSTOMER")
@NamedQueries({
    @NamedQuery(name = Customer.GET_ALL_QUERY_NAME, query = "SELECT c FROM Customer c order by c.customerId desc")})

public class Customer implements Serializable{
	
	public static final String GET_ALL_QUERY_NAME = "Customer.getAll";

	private int customerId;
    private String customerName;
    private String customerAddress;
    
    private String customerCEO;
    private int customerABN;
    private int NumOfPeople;
    private double customerRate;
    private Industry industry;
    private Set<CustomerContact> customerContact;
    private AppUser appUser;
    
    public Customer() {
    	
    }
    
	public Customer(Integer customerId,String customerName, String customerAddress, String customerCEO, int customerABN,
			int numOfPeople, double customerRate, Industry industry, AppUser appUser) 
	{
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerCEO = customerCEO;
		this.customerABN = customerABN;
		NumOfPeople = numOfPeople;
		this.customerRate = customerRate;
		this.industry = industry;
		this.appUser = appUser;
		this.customerContact = new HashSet<>();
		
	}

	@Id
    @GeneratedValue
    @Column(name = "customer_id")
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Column(name = "customername")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public String getCustomerCEO() {
		return customerCEO;
	}

	public void setCustomerCEO(String customerCEO) {
		this.customerCEO = customerCEO;
	}

	public int getCustomerABN() {
		return customerABN;
	}

	public void setCustomerABN(int customerABN) {
		this.customerABN = customerABN;
	}

	public int getNumOfPeople() {
		return NumOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		NumOfPeople = numOfPeople;
	}

	public double getCustomerRate() {
		return customerRate;
	}

	public void setCustomerRate(double customerRate) {
		this.customerRate = customerRate;
	}

	@ManyToOne
	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	//Each contactNumber has one and only one contact person. 
    //Each customer might be responsible for zero to many contactNumber
	@OneToMany (mappedBy = "customer",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	public Set<CustomerContact> getCustomerContact() {
		return customerContact;
	}
	
	//-----------------------
	 private void writeObject(ObjectOutputStream stream)
		        throws IOException {
		 customerContact.isEmpty(); // this will load lazy data in a portable way
		    stream.defaultWriteObject(); // this will continue serializing your object in usual way
		  }
	 
	 //------------------------

	public void setCustomerContact(Set<CustomerContact> customerContact) {
		this.customerContact = customerContact;
	}
	
	@ManyToOne
	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	
	
    
    
}

