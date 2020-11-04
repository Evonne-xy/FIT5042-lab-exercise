package fit5042.assignment.mbeans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fit5042.assignment.controllers.ContactTemporary;
import fit5042.assignment.repository.CustomerContactRepository;
import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.CustomerContact;
import fit5042.assignment.repository.entities.Industry;
import fit5042.assignment.repository.entities.Staff;



@ManagedBean(name = "CustomerContactManagedBean")
@SessionScoped
public class CustomerContactManageBean implements Serializable{
	
	@EJB
	CustomerContactRepository customerContactRepository;
	
	public CustomerContactManageBean() {
		
	}
	
	public List<CustomerContact> getAllCustomerContact(){
		try {
			List<CustomerContact> customerContacts = customerContactRepository.getAllCustomerContact();
			return customerContacts;
			
		}catch (Exception ex) {
			Logger.getLogger(CustomerContactManageBean.class.getName(), null).log(Level.SEVERE, null, ex);
			
		}
		return null;
	}
	
	public void addCustomerContact(CustomerContact customerContact) {
		try {
			customerContactRepository.addCustomerContact(customerContact);
			
		}catch(Exception ex){
			Logger.getLogger(CustomerContactManageBean.class.getName(),null).log(Level.SEVERE, null,ex);
			ex.printStackTrace();
		}
	}
	
	public void removeCustomerContact(int customerContactId) {
		try {
			customerContactRepository.removeCustomerContact(customerContactId);
        } catch (Exception ex) {
            Logger.getLogger(CustomerContactManageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void editCustomerContact(CustomerContact customerContact) {
		try {
			customerContactRepository.editCustomerContact(customerContact);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer Contact has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(CustomerContactManageBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
	}
	
	public CustomerContact searchCustomerContactById(int customerContactId) {
		 try {
	            return customerContactRepository.searchCustomerContactById(customerContactId);
	        } catch (Exception ex) {
	            Logger.getLogger(CustomerContactManageBean.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return null;
	}
	
	public Customer searchCustomerByContactPerson(CustomerContact customerContact) {
		try {
            return customerContactRepository.searchCustomerByContactPerson(customerContact);
        } catch (Exception ex) {
            Logger.getLogger(CustomerContactManageBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
	}
	
	public void addCustomerContact(fit5042.assignment.controllers.ContactTemporary locaContactTemporary) {
		CustomerContact contact = convertContactToEntity(locaContactTemporary);
		try {
			customerContactRepository.addCustomerContact(contact);
		} catch (Exception ex) {
			Logger.getLogger(CustomerContactManageBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

	private CustomerContact convertContactToEntity(fit5042.assignment.controllers.ContactTemporary locaContactTemporary) {
		CustomerContact contact = new CustomerContact();
		contact.setContactId(contact.getContactId());
		contact.setContactFirstName(locaContactTemporary.getContactFirstName());
		contact.setContactLastName(locaContactTemporary.getContactLastName());
		contact.setContactEmail(locaContactTemporary.getContactEmail());
		contact.setContactPersonalPhone(locaContactTemporary.getContactPersonalPhone());
		contact.setContactGender(locaContactTemporary.getContactGender());
		
		int customerId = locaContactTemporary.getContactId();
		String customerName = locaContactTemporary.getCustomerName();
		String customerAddress = locaContactTemporary.getCustomerAddress();
		String CustomerCEO = locaContactTemporary.getCustomerCEO();
		int customerABN = locaContactTemporary.getCustomerABN();
		int numOfPeople = locaContactTemporary.getNumOfPeople();
		double customerRate = locaContactTemporary.getCustomerRate();
		
		Industry industry = locaContactTemporary.getIndustry();
		Staff staff = locaContactTemporary.getStaffId();
		Customer customer = new fit5042.assignment.repository.entities.Customer(customerId, customerName, customerAddress, CustomerCEO, customerABN,numOfPeople,customerRate, industry,staff);
		if(customer.getCustomerId() == 0) {
			customer = null;
		}
		contact.setCustomer(customer);
		return contact;
	}

}
















