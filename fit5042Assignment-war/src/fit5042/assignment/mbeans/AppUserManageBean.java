package fit5042.assignment.mbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fit5042.assignment.controllers.AppUserTemporary;
import fit5042.assignment.repository.AppUserRepository;
import fit5042.assignment.repository.entities.AppUser;
import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.CustomerContact;
import fit5042.assignment.repository.entities.Staff;

@ManagedBean(name = "AppUserManageBean")
@SessionScoped
public class AppUserManageBean implements Serializable {
	@EJB
	AppUserRepository appUserRepository;
	
	public AppUserManageBean() {
		
		
	}
	
	public List<AppUser> getAllAppUser(){
		try {
			List<AppUser> appUser = appUserRepository.getAllAppUser();
			return appUser;
			
		}catch (Exception ex) {
			Logger.getLogger(AppUserManageBean.class.getName(), null).log(Level.SEVERE, null, ex);
			
		}
		return null;
	}
	
	public List<Staff> getAllStaff(){
		try {
			List<Staff> staff = appUserRepository.getAllStaffs();
			return staff;
			
		}catch (Exception ex) {
			Logger.getLogger(AppUserManageBean.class.getName(), null).log(Level.SEVERE, null, ex);
			
		}
		return null;
	}
	
	public void addAppUser(fit5042.assignment.controllers.AppUserTemporary appUserTemporary) {
		AppUser appUser = convertCustomerToEntity(appUserTemporary);
		
		try {
			appUserRepository.addAppUser(appUser);
			
		}catch(Exception ex){
			Logger.getLogger(AppUserManageBean.class.getName(),null).log(Level.SEVERE, null,ex);
			ex.printStackTrace();
		}	
	}
	
	private AppUser convertCustomerToEntity(AppUserTemporary appUserTemporary) {
		AppUser appUser = new AppUser();
		int id = appUserTemporary.getId();
		String username = appUserTemporary.getUsername();
		String password = appUserTemporary.getPassword();
		Date dob = appUserTemporary.getDob();
		String userLevel = appUserTemporary.getUserLevel();
		appUser.setId(id);
		appUser.setUsername(username);
		appUser.setPassword(password);
		appUser.setDob(dob);
		appUser.setUserLevel(userLevel);
		
		return appUser;
	}


	public void removeAppUser(int appUserId) {
		try {
			appUserRepository.removeAppUser(appUserId);
        } catch (Exception ex) {
            Logger.getLogger(AppUserManageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void editAppUser(AppUser appUser) {
		try {
			appUserRepository.editAppUser(appUser);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AppUser has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(AppUserManageBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
	}
	
	public AppUser searchAppUserById(int id) {
		 try {
	            return appUserRepository.searchAppUserById(id);
	        } catch (Exception ex) {
	            Logger.getLogger(AppUserManageBean.class.getName()).log(Level.SEVERE, null, ex);
	        };

	        return null;
	}

}
