package fit5042.assignment.controllers;

import java.io.Console;
import java.io.Serializable;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.assignment.mbeans.CustomerContactManageBean;
import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.CustomerContact;


@SessionScoped
@Named("addContact")
public class AddContact implements Serializable{
	@ManagedProperty(value = "#{CustomerContactManagedBean}")
	CustomerContactManageBean customerContactManageBean;
	private boolean showForm = true;
	private ContactTemporary contactTemporary;
	AusApplication ausApp;
	private int customerId;
	
	private fit5042.assignment.repository.entities.Customer customer;
	private CustomerContact customerContact;
	
	public AddContact() {
		
		customerId = Integer.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("customerAdd"));
		
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		
		ausApp = (AusApplication) FacesContext.getCurrentInstance()
				.getApplication()
				.getELResolver()
				.getValue(context, null,"AusApplication" );
		
		ausApp.updateCustomerContactList();
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerContactManageBean = (CustomerContactManageBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "CustomerContactManagedBean");
		
		customerContact = new CustomerContact();
		setCustomer(ausApp.getCustomerById(customerId));	
	}
	

	public void addContact() {
		try {
			Customer temp = getCustomer();
			customerContact.setCustomer(getCustomer());
			customerContactManageBean.addCustomerContact(customerContact);
			ausApp.searchAllContact();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contact has been added succesfully"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;
	}

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public ContactTemporary getContactTemporary() {
		return contactTemporary;
	}

	public void setContactTemporary(ContactTemporary contactTemporary) {
		this.contactTemporary = contactTemporary;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public fit5042.assignment.repository.entities.Customer getCustomer() {
		return customer;
	}


	public void setCustomer(fit5042.assignment.repository.entities.Customer customer) {
		this.customer = customer;
	}


	public CustomerContact getCustomerContact() {
		return customerContact;
	}


	public void setCustomerContact(CustomerContact customerContact) {
		this.customerContact = customerContact;
	}
	
	
	
	
}
