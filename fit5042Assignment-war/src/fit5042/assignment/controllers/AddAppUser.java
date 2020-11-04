package fit5042.assignment.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.AppUserManageBean;
import fit5042.assignment.mbeans.CustomerContactManageBean;
import fit5042.assignment.mbeans.CustomerManageBean;
import fit5042.assignment.repository.entities.AppUser;
import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.CustomerContact;

@RequestScoped
@Named("AddAppUser")
public class AddAppUser implements Serializable{
	@ManagedProperty(value = "#{AppUserManageBean}")
	AppUserManageBean appUserManageBean;
	private boolean showForm = true;
	AusApplication ausApp;
	private int appUserId;
	private AppUserTemporary appUserTemporary;
	
	//private fit5042.assignment.repository.entities.AppUser appUser;
	
	public AddAppUser() {
		
	}
	
	@PostConstruct
	public void init() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		
		ausApp = (AusApplication) FacesContext.getCurrentInstance()
				.getApplication()
				.getELResolver()
				.getValue(context, null,"AusApplication" );
		
		ausApp.updateAppUserList();
		appUserManageBean = (AppUserManageBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(context, null, "AppUserManageBean");
	
	}
	
	public void addAppUserInfo(AppUserTemporary appUserTemporary) {
		try {
			appUserManageBean.addAppUser(appUserTemporary);
			ausApp.searchAllAppUser();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("App User has been added succesfully"));
			
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

	public int getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(int appUserId) {
		this.appUserId = appUserId;
	}

	/*
	 * public fit5042.assignment.repository.entities.AppUser getAppUser() { return
	 * appUser; }
	 * 
	 * public void setAppUser(fit5042.assignment.repository.entities.AppUser
	 * appUser) { this.appUser = appUser; }
	 */
	public AppUserTemporary getAppUserTemporary() {
		return appUserTemporary;
	}

	public void setAppUserTemporary(AppUserTemporary appUserTemporary) {
		this.appUserTemporary = appUserTemporary;
	}

	
	
	
}
