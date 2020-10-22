package fit5042.assignment.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.sun.glass.ui.Application;

import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.CustomerContact;

@Named(value = "CustomerController")
@SessionScoped
public class CustomerController implements Serializable {

	private int customerId;
	
	private fit5042.assignment.repository.entities.Customer customer;
	
	private fit5042.assignment.repository.entities.Customer addCustomer;
	public CustomerController() {
		customerId = Integer.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("customerID"));
		customer = getCustomer();
		addCustomer = getAddCustomer();
	}

	
	public fit5042.assignment.repository.entities.Customer getCustomer() {
		if(customer == null) {
			ELContext context
			= FacesContext.getCurrentInstance().getELContext();
			AusApplication ausApp = 
					(AusApplication) FacesContext.getCurrentInstance()
					.getApplication()
					.getELResolver().
					getValue(context, null, "AusApplication");
			ArrayList<Customer> customers = ausApp.getCustomers();			
			return ausApp.getCustomers().get(--customerId);
		}
		return customer;		
	}
	
	public fit5042.assignment.repository.entities.Customer getAddCustomer() {
		if(customer == null) {
			ELContext context
			= FacesContext.getCurrentInstance().getELContext();
			AusApplication ausApp = 
					(AusApplication) FacesContext.getCurrentInstance()
					.getApplication()
					.getELResolver().
					getValue(context, null, "AusApplication");
			Customer customerById = ausApp.getCustomerById(customerId);			
			return ausApp.getCustomerById(customerId);
		}
		return customer;		
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	
}
