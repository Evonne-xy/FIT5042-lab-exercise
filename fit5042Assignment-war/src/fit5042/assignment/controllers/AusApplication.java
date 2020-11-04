package fit5042.assignment.controllers;

import java.util.ArrayList;
import java.util.Set;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omg.CORBA.PRIVATE_MEMBER;

import fit5042.assignment.mbeans.AppUserManageBean;
import fit5042.assignment.mbeans.CustomerContactManageBean;
import fit5042.assignment.mbeans.CustomerManageBean;
import fit5042.assignment.repository.entities.AppUser;
import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.CustomerContact;


@Named(value = "AusApplication")
@ApplicationScoped
public class AusApplication {
	@ManagedProperty(value = "#{CustomerManagedBean}")
	CustomerManageBean customerManageBean;
	
	@ManagedProperty(value = "#{CustomerContactManagedBean}")
	CustomerContactManageBean customerContactManagedBean;
	
	@ManagedProperty(value = "#{AppUserManageBean}")
	AppUserManageBean appUserManageBean;
	
	private ArrayList<Customer> customers;
	private ArrayList<CustomerContact> customerContacts;
	private ArrayList<AppUser> appUsers;
	private boolean showForm = true;
	
	private String username;
	
	public boolean isShowForm() {
        return showForm;
    }
	
	//Add customer data from database to app
	public AusApplication() throws Exception{
		
		customers = new ArrayList<Customer>();
		customerContacts = new ArrayList<CustomerContact>();
		appUsers = new ArrayList<AppUser>();
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerManageBean = (CustomerManageBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, "CustomerManagedBean");
		customerContactManagedBean = (CustomerContactManageBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, "CustomerContactManagedBean");
		appUserManageBean = (AppUserManageBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, "AppUserManageBean");
		updateCustomerList();
		updateCustomerContactList();
		updateAppUserList();
		
		username =   FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		String teString = username;
	}

	
	public void updateAppUserList() {
		if (appUsers != null && appUsers.size() > 0)
        {
            
        }
        else
        {
        	appUsers.clear();

            for (fit5042.assignment.repository.entities.AppUser appUser : appUserManageBean.getAllAppUser())
            {
            	if(appUser.getUsername().contains("staff")) {
            		appUsers.add(appUser);
            	}
            	
            }

            setAppUsers(appUsers);
        }
		
	}
	
	public AppUser getAppUserById(int appUserId) {
		AppUser appUser = new AppUser();

        for (fit5042.assignment.repository.entities.AppUser appUsers : appUserManageBean.getAllAppUser())
        {
        	if(appUsers.getId() == appUserId)
        	{
        		appUser = appUsers;
        		return appUser;
        	}
        }
	return appUser;
}


	public void updateCustomerContactList() {
		if (customerContacts != null && customerContacts.size() > 0)
        {
            
        }
        else
        {
        	customerContacts.clear();

            for (fit5042.assignment.repository.entities.CustomerContact customerContact : customerContactManagedBean.getAllCustomerContact())
            {
            	customerContacts.add(customerContact);
            }

            setCustomerContacts(customerContacts);
        }
		
	}
	
	public void searchCustomerContactById(int id) {
		customerContacts.clear();
		customerContacts.add(customerContactManagedBean.searchCustomerContactById(id));
	}
	
	public void searchAllCustomerContact()
    {
		customerContacts.clear();
		for(fit5042.assignment.repository.entities.CustomerContact customerContact : customerContactManagedBean.getAllCustomerContact())
		{
			customerContacts.add(customerContact);
		}
    }
	
	
	//when loading, and after adding or deleting, the Customer list needs to be refreshed
    //this method is for that purpose
	public void updateCustomerList() {
		if (customers != null && customers.size() > 0)
        {
            
        }
        else
        {
        	customers.clear();

            for (fit5042.assignment.repository.entities.Customer customer : customerManageBean.getAllCustomers())
            {
            	String userNameTest = customer.getAppUser().getUsername();
            	//if(username.equals(userNameTest)) {
            		customers.add(customer);
            	//}
            	
            }

            setCustomers(customers);
        }
	}
	
	// get customer through by id--> Addcontact
	public Customer getCustomerById(int customerId) {
			Customer addCustomer = new Customer();

            for (fit5042.assignment.repository.entities.Customer customer : customerManageBean.getAllCustomers())
            {
            	if(customer.getCustomerId() == customerId)
            	{
            		addCustomer = customer;
            		return addCustomer;
            	}
            }
      
		return addCustomer;
	}
	
	// get contact through by id--> Addcontact
		public CustomerContact getContactById(int contactId) {
				CustomerContact customerContact = new CustomerContact();

	            for (fit5042.assignment.repository.entities.CustomerContact customerContact2 : customerContactManagedBean.getAllCustomerContact())
	            {
	            	if(customerContact2.getContactId() == contactId)
	            	{
	            		customerContact = customerContact2;
	            		return customerContact;
	            	}
	            }
	      
			return customerContact;
		}
	
	
	public void searchCustomerById(int id) {
		customers.clear();
		customers.add(customerManageBean.searchCustomerById(id));
	}
	
	//------------------------------------------
	public void searchCustomerByName(String customerName) {
		customers.clear();
		customers.add(customerManageBean.searchCustomerByName(customerName));
	}
	
	public void searchCustomerByName2(String customerName) {
		customers.clear();

        for (fit5042.assignment.repository.entities.Customer customer : customerManageBean.searchCustomerByName2(customerName)) {
        	customers.add(customer);
        }

        setCustomers(customers);
	}
	
	//-----------------------------------------------------
	
	public void searchContactById(int id) {
		customerContacts.clear();
		customerContacts.add(customerContactManagedBean.searchCustomerContactById(id));
	}
	
	public void searchAppUserById(int id) {
		appUsers.clear();
		appUsers.add(appUserManageBean.searchAppUserById(id));
	}
	
	public void searchAllCustomer()
    {
		customers.clear();
		for(fit5042.assignment.repository.entities.Customer customer : customerManageBean.getAllCustomers())
		{
			customers.add(customer);
		}
    }
	
	public void searchAllContact()
    {
		customerContacts.clear();
		for(fit5042.assignment.repository.entities.CustomerContact contact : customerContactManagedBean.getAllCustomerContact())
		{
			customerContacts.add(contact);
		}
    }
	
	public void searchAllAppUser()
    {
		appUsers.clear();
		for (fit5042.assignment.repository.entities.AppUser appUser : appUserManageBean.getAllAppUser())
		{
			if(appUser.getUsername().contains("staff")) {
				appUsers.add(appUser);
			}
		}
    }

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<CustomerContact> getCustomerContacts() {
		return customerContacts;
	}

	public void setCustomerContacts(ArrayList<CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}

	public ArrayList<AppUser> getAppUsers() {
		return appUsers;
	}

	public void setAppUsers(ArrayList<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
	
	
}
