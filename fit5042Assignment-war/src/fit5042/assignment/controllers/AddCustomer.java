package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.CustomerManageBean;

@RequestScoped
@Named("addCustomer")
public class AddCustomer {
	@ManagedProperty(value = "#{CustomerManagedBean}")
	CustomerManageBean customerManageBean;
	private boolean showForm = true;
	private CustomerTemporary customerTemporary;
	AusApplication ausApp;
	
	public AddCustomer() {
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
	
	public void addCustomer(CustomerTemporary localCustomerTemporary) {
		try {
			customerManageBean.addCustomer(localCustomerTemporary);
			ausApp.searchAllCustomer();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been added succesfully"));
			
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
	public CustomerTemporary getCustomerTemporary() {
		return customerTemporary;
	}
	public void setCustomerTemporary(CustomerTemporary customerTemporary) {
		this.customerTemporary = customerTemporary;
	}
	
	
}
