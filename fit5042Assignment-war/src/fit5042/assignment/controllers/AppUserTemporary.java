package fit5042.assignment.controllers;

import java.util.Date;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import fit5042.assignment.repository.entities.AppUser;
import fit5042.assignment.repository.entities.Customer;

@RequestScoped
@Named(value = "AppUserTemporary")
public class AppUserTemporary {
	 	private int id;
	    private String username;
	    private String password;
	    private Date dob;
		private Set<Customer> customerMangement;
		private String userLevel;
		private Set<fit5042.assignment.repository.entities.AppUser> appUsers;
		
		public AppUserTemporary() {
			
			
		}
		

		public AppUserTemporary(int id, String username, String password, Date dob, Set<Customer> customerMangement,
				String userLevel, Set<AppUser> appUsers) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.dob = dob;
			this.customerMangement = customerMangement;
			this.userLevel = userLevel;
			this.appUsers = appUsers;
		}



		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public Set<Customer> getCustomerMangement() {
			return customerMangement;
		}

		public void setCustomerMangement(Set<Customer> customerMangement) {
			this.customerMangement = customerMangement;
		}

		public String getUserLevel() {
			return userLevel;
		}

		public void setUserLevel(String userLevel) {
			this.userLevel = userLevel;
		}

		public Set<fit5042.assignment.repository.entities.AppUser> getAppUsers() {
			return appUsers;
		}

		public void setAppUsers(Set<fit5042.assignment.repository.entities.AppUser> appUsers) {
			this.appUsers = appUsers;
		}
		
		
}
