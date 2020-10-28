package fit5042.assignment.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.CustomerContact;

@ManagedBean(name = "CustomerController")
@ViewScoped
public class CustomerController implements Serializable {

	private int customerId;
	
	private fit5042.assignment.repository.entities.Customer customer;
	
	public CustomerController() {
		
	}
	
	@PostConstruct
	public void init() {
		customerId = Integer.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("customerID"));
		//customer = getCustomer();
		customer = getAddCustomer();
	}
	
	public fit5042.assignment.repository.entities.Customer getAddCustomer() {
		//if(customer == null) {
			ELContext context
			= FacesContext.getCurrentInstance().getELContext();
			AusApplication ausApp = 
					(AusApplication) FacesContext.getCurrentInstance()
					.getApplication()
					.getELResolver().
					getValue(context, null, "AusApplication");
			//Customer customerById = ausApp.getCustomerById(customerId);			
			return ausApp.getCustomerById(customerId);
		//}
		//return customer;		
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

	
	
}
