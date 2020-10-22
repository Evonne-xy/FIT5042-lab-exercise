package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.CustomerContactManageBean;

@RequestScoped
@Named("removeContact")
public class RemoveContact {
	@ManagedProperty(value = "#{CustomerContactManagedBean}")
	CustomerContactManageBean customerContactManagedBean;
	private boolean showForm = true;
	private ContactTemporary contactTemporary;
	AusApplication ausApp;
	
	public RemoveContact() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ausApp = (AusApplication) FacesContext.getCurrentInstance()
				.getApplication()
				.getELResolver()
				.getValue(context, null,"AusApplication" );
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerContactManagedBean = (CustomerContactManageBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, "CustomerContactManagedBean");
	}
	
	public void removeContact(int contactId) {
		try {
			customerContactManagedBean.removeCustomerContact(contactId);
			ausApp.searchAllContact();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer contact has been deleted succesfully"));
		} catch (Exception ex) {
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
	

}
