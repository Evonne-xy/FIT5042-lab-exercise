package fit5042.assignment.controllers;

import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import fit5042.assignment.repository.entities.CustomerContact;
import fit5042.assignment.repository.entities.Industry;
import fit5042.assignment.repository.entities.Staff;

@RequestScoped
@Named(value = "CustomerTemporary")
public class CustomerTemporary {

	private int customerId;
	private String customerName;
    private String customerAddress;
    
    private String customerCEO;
    private int customerABN;
    private int NumOfPeople;
    private double customerRate;
    private Industry industry;
    private Set<CustomerContact> customerContact;
    private Staff staff;
    
    private int industryId;
	private String industryType;
    
	private int contactId;
	private String contactFirstName;
	private String contactLastName;
	private String contactEmail;
	private int contactPersonalPhone;
	private String contactGender;
	
	private int staffId;
	private String staffName;
	
	private Set<fit5042.assignment.repository.entities.Customer> customers;
	
	public CustomerTemporary() {
		
	}

	public CustomerTemporary(int customerId, String customerName, String customerAddress, String customerCEO,
			int customerABN, int numOfPeople, double customerRate, Industry industry,
			Set<CustomerContact> customerContact, Staff staff) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerCEO = customerCEO;
		this.customerABN = customerABN;
		NumOfPeople = numOfPeople;
		this.customerRate = customerRate;
		this.industry = industry;
		this.customerContact = customerContact;
		this.staff = staff;
	}

	 //=================================================================================

	

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

	public void setCustomers(Set<fit5042.assignment.repository.entities.Customer> customers) {
	        this.customers = customers;
	}

	
	public Set<fit5042.assignment.repository.entities.Customer> getCustomers() {
	        return customers;
	}
	
	//==================================================================================
	

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

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public Set<CustomerContact> getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(Set<CustomerContact> customerContact) {
		this.customerContact = customerContact;
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


	
	
	
	
	
}
