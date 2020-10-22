package fit5042.assignment.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.Industry;
import fit5042.assignment.repository.entities.Staff;

@RequestScoped
@Named(value = "ContactTemporary")
public class ContactTemporary {

	private int contactId;
	private String contactFirstName;
	private String contactLastName;
	private String contactEmail;
	private int contactPersonalPhone;
	private String contactGender;
	
	private Customer customer;
	
	private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerCEO;
    private int customerABN;
    private int NumOfPeople;
    private double customerRate;
    private Industry industry;
    private Staff staffId;
	
    private fit5042.assignment.repository.entities.Customer customers;
    
    public ContactTemporary() {
    	
    }

    public ContactTemporary(int contactId, String contactFirstName, String contactLastName, String contactEmail,
			int contactPersonalPhone, String contactGender, Customer customer) {
		super();
		this.contactId = contactId;
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.contactEmail = contactEmail;
		this.contactPersonalPhone = contactPersonalPhone;
		this.contactGender = contactGender;
		this.customer = customer;
	}

	//============================================================================

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public Staff getStaffId() {
		return staffId;
	}

	public void setStaffId(Staff staffId) {
		this.staffId = staffId;
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

	public fit5042.assignment.repository.entities.Customer getCustomers() {
		return customers;
	}
	public void setCustomers(fit5042.assignment.repository.entities.Customer customers) {
		this.customers = customers;
	}
	
	


    //============================================================================
    
	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
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

	public String getContactGender() {
		return contactGender;
	}

	public void setContactGender(String contactGender) {
		this.contactGender = contactGender;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	
	
	
	
}
