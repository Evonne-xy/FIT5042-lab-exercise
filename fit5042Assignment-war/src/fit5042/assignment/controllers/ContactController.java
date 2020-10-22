package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "ContactController")
@RequestScoped
public class ContactController {
	private int contactId;
	private fit5042.assignment.repository.entities.CustomerContact customerContact;
	
	public ContactController() {
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
			return ausApp.getCustomerContacts().get(--contactId);
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
