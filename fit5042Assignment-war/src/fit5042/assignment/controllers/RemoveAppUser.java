package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.AppUserManageBean;
import fit5042.assignment.mbeans.CustomerContactManageBean;

@RequestScoped
@Named("RemoveAppUser")
public class RemoveAppUser {
	@ManagedProperty(value = "#{AppUserManageBean}")
	AppUserManageBean appUserManageBean;
	private boolean showForm = true;
	AusApplication ausApp;
	private int appUserId;
	
	public RemoveAppUser() {
		appUserId = Integer.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("appUserId"));
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ausApp = (AusApplication) FacesContext.getCurrentInstance()
				.getApplication()
				.getELResolver()
				.getValue(context, null,"AusApplication" );
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		appUserManageBean = (AppUserManageBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, "AppUserManageBean");
	}
	
	public void removeAppUser(int appUserId) {
		try {
			appUserManageBean.removeAppUser(appUserId);
			ausApp.searchAllAppUser();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AppUser has been deleted succesfully"));
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

	public AusApplication getAusApp() {
		return ausApp;
	}

	public void setAusApp(AusApplication ausApp) {
		this.ausApp = ausApp;
	}

	public int getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(int appUserId) {
		this.appUserId = appUserId;
	}
	
	

}
