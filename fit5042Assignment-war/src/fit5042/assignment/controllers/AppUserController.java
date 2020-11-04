package fit5042.assignment.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "AppUserController")
@ViewScoped
public class AppUserController implements Serializable{
	
	private int appUserId;
	
	private fit5042.assignment.repository.entities.AppUser appUser;
	
	public AppUserController() {
		
	}
	
	@PostConstruct
	public void init() {
		appUserId = Integer.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("appUserId"));
		appUser = getAppUserInfo();
	}
	
	public fit5042.assignment.repository.entities.AppUser getAppUserInfo(){
			ELContext context
			= FacesContext.getCurrentInstance().getELContext();
			AusApplication ausApp = 
					(AusApplication) FacesContext.getCurrentInstance()
					.getApplication()
					.getELResolver().
					getValue(context, null, "AusApplication");	
			return ausApp.getAppUserById(appUserId);
	}

	public int getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(int appUserId) {
		this.appUserId = appUserId;
	}

	public fit5042.assignment.repository.entities.AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(fit5042.assignment.repository.entities.AppUser appUser) {
		this.appUser = appUser;
	}
	
	

}
