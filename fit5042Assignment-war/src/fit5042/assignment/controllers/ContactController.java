package fit5042.assignment.controllers;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


//@Named(value = "ContactController")
//@RequestScoped
@ManagedBean(name = "ContactController")
@ViewScoped
public class ContactController {
	private int contactId;
	private fit5042.assignment.repository.entities.CustomerContact customerContact;
	
	public ContactController() {
		
	}
	
	@PostConstruct
	public void init() {
		contactId = Integer.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("contactID"));
		customerContact = getCustomerContact();	
		
	}

	public fit5042.assignment.repository.entities.CustomerContact getCustomerContact() {
		if(customerContact == null) {
			ELContext context
			= FacesContext.getCurrentInstance().getELContext();
			AusApplication ausApp = 
					(AusApplication) FacesContext.getCurrentInstance()
					.getApplication()
					.getELResolver().
					getValue(context, null, "AusApplication");
			return ausApp.getContactById(contactId);
		}
		return customerContact;	
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	
		
	
}
