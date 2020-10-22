package fit5042.assignment.repository.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
@NamedQueries({
    @NamedQuery(name = CustomerContact.GET_ALL_QUERY_NAME, query = "SELECT c FROM CustomerContact c order by c.contactId desc")})

public class CustomerContact implements Serializable{
	
	public static final String GET_ALL_QUERY_NAME = "CustomerContact.getAll";
	private int contactId;
	private String contactFirstName;
	private String contactLastName;
	private String contactEmail;
	private int contactPersonalPhone;
	private String contactGender;
	private Customer customer;
	
	
	public CustomerContact() {
		
	}
	

	public CustomerContact(int contactId, String contactFirstName, String contactLastName, String contactEmail,
			int contactPersonalPhone, String contactGender) {
		super();
		this.contactId = contactId;
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.contactEmail = contactEmail;
		this.contactPersonalPhone = contactPersonalPhone;
		this.contactGender = contactGender;
		//this.customer = customer;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "contact_id")
	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}


	public String getContactFirstName() {
		return contactFirstName;
	}


	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}


	public String getContactLastName() {
		return contactLastName;
	}


	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}


	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public int getContactPersonalPhone() {
		return contactPersonalPhone;
	}


	public void setContactPersonalPhone(int contactPersonalPhone) {
		this.contactPersonalPhone = contactPersonalPhone;
	}


	public String getContactGender() {
		return contactGender;
	}



	public void setContactGender(String contactGender) {
		this.contactGender = contactGender;
	}

	//enforce the relationship between a customerContact and customer using annotation(s). 
    //Each customerContact has one and only one customer. 
    //Each customer might be responsible for zero to many customerContact
	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "CustomerContact [contactId=" + contactId + ", contactFirstName=" + contactFirstName
				+ ", contactLastName=" + contactLastName + ", contactEmail=" + contactEmail + ", contactPersonalPhone="
				+ contactPersonalPhone + ", contactGender=" + contactGender + ", customer=" + customer + "]";
	}


	
	

//	 //annotate the attribute tags in customerContact class so that the tags of a customerContact will be stored in a table called TAG. 
//    //The tags of a customerContact should be eagerly fetched and the value of each tag must be stored in a column VALUE in the TAG table
//	
//	@ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "TAG")
//    @Column(name = "VALUE")
//	public Set<String> getTags() {
//		return tags;
//	}
//
//	public void setTags(Set<String> tags) {
//		this.tags = tags;
//	}

	

	
	
}

