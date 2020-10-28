package fit5042.assignment.controllers;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.CustomerManageBean;
import fit5042.assignment.repository.entities.Customer;
import javanet.staxutils.helpers.ElementContext;

@RequestScoped
@Named("removeCustomer")
public class RemoveCustomer {

	@ManagedProperty(value = "#{CustomerManagedBean}")
	CustomerManageBean customerManageBean;
	
	private boolean showForm = true;
	private CustomerTemporary customerTemporary;
	AusApplication ausApp;
	private int customerId;
	
	public RemoveCustomer() {
		customerId = Integer.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("customerId"));
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		
		ausApp = (AusApplication) FacesContext.getCurrentInstance()
				.getApplication()
				.getELResolver()
				.getValue(context, null,"AusApplication" );
		
		ausApp.updateCustomerList();
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerManageBean = (CustomerManageBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "CustomerManagedBean");
	}
	
	public void removeCustomer() {
		try {
			customerManageBean.removeCustomer(customerId);
			ausApp.searchAllCustomer();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been deleted succesfully"));
			
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
	public CustomerTemporary getCustomerTemporary() {
		return customerTemporary;
	}
	public void setCustomerTemporary(CustomerTemporary customerTemporary) {
		this.customerTemporary = customerTemporary;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
}
