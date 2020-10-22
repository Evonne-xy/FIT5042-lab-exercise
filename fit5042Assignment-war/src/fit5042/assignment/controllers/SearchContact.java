package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@RequestScoped
@Named("searchContact")
public class SearchContact {
	private boolean showForm = true;
	private ContactTemporary contactTemporary;
	AusApplication ausApp;
	private int searchByInt;
	
	public SearchContact() {
		ELContext context
        = FacesContext.getCurrentInstance().getELContext();

		ausApp = (AusApplication) FacesContext.getCurrentInstance()
        .getApplication()
        .getELResolver()
        .getValue(context, null, "AusApplication");

		ausApp.updateCustomerContactList();
	}
	
	public void searchContactById(int contactId) {
		try {
			ausApp.searchContactById(contactId);
		}catch (Exception ex) {
			
		}
		showForm = true;
	}
	
	public void searchAll() {
		try {
			ausApp.searchAllContact();
			
		} catch (Exception ex) {
		
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

	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}

	public AusApplication getAusApp() {
		return ausApp;
	}

	public void setAusApp(AusApplication ausApp) {
		this.ausApp = ausApp;
	}
	
	
	
	
	
}
