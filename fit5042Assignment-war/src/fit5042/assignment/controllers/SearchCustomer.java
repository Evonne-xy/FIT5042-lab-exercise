package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@RequestScoped
@Named("searchCustomer")
public class SearchCustomer {
	private boolean showForm = true;
	private CustomerTemporary customerTemporary;
	AusApplication ausApp;
	private int searchByInt; 
	private String searchByString;
	
	public SearchCustomer() {
		ELContext context
        = FacesContext.getCurrentInstance().getELContext();

		ausApp = (AusApplication) FacesContext.getCurrentInstance()
        .getApplication()
        .getELResolver()
        .getValue(context, null, "AusApplication");

		ausApp.updateCustomerList();
	}
	
	public void searchCustomerById(int customerId) {
		try {
			ausApp.searchCustomerById(customerId);
		}catch (Exception ex) {
			
		}
		showForm = true;
	}
	
	public void searchCustomerByName(String customerName) {
		try {
			ausApp.searchCustomerByName(customerName);
		}catch (Exception ex) {
			
		}
		showForm = true;
	}
	
	public void searchAll() {
		try {
			ausApp.searchAllCustomer();
			
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

	public CustomerTemporary getCustomerTemporary() {
		return customerTemporary;
	}

	public void setCustomerTemporary(CustomerTemporary customerTemporary) {
		this.customerTemporary = customerTemporary;
	}

	public AusApplication getAusApp() {
		return ausApp;
	}

	public void setAusApp(AusApplication ausApp) {
		this.ausApp = ausApp;
	}

	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}

	public String getSearchByString() {
		return searchByString;
	}

	public void setSearchByString(String searchByString) {
		this.searchByString = searchByString;
	}

	
	
	

}
