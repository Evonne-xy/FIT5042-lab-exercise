package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@RequestScoped
@Named("searchUser")
public class searchUser {
	private boolean showForm = true;
	AusApplication ausApp;
	private int searchByInt; 
	private String searchByString;
	
	public searchUser() {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		ausApp = (AusApplication)FacesContext.getCurrentInstance()
				.getApplication()
				.getELResolver()
				.getValue(elContext, null, "AusApplication");
		
	}
	
	public void searchAppUserById(int appUserId) {
		try {
			ausApp.searchAppUserById(appUserId);
		}catch (Exception ex) {
			
		}
		showForm = true;
	}
	
	public void searchAll() {
		try {
			ausApp.searchAllAppUser();
			
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
