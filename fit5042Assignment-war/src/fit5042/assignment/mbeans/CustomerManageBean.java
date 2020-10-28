package fit5042.assignment.mbeans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.ejb.EJB;

import fit5042.assignment.repository.CustomerRepository;
import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.CustomerContact;
import fit5042.assignment.repository.entities.Industry;
import fit5042.assignment.repository.entities.Staff;


@ManagedBean(name = "CustomerManagedBean")
@SessionScoped
public class CustomerManageBean implements Serializable{

	@EJB
	CustomerRepository customerRepository;
	
	public CustomerManageBean() {
		
	}
	
	public List<Customer> getAllCustomers(){
		try {
			List<Customer> customers = customerRepository.getAllCustomers();
			return customers;
			
		}catch (Exception ex) {
			Logger.getLogger(CustomerManageBean.class.getName(), null).log(Level.SEVERE, null, ex);
			
		}
		return null;
	}
	
	public void addCustomer(Customer customer) {
		try {
			customerRepository.addCustomer(customer);
			
		}catch (Exception ex) {
			Logger.getLogger(CustomerManageBean.class.getName(), null).log(Level.SEVERE, null, ex);
		}
	}
	
	public void removeCustomer(int customerId) {
		try {
			customerRepository.removeCustomer(customerId);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void editCustomer(Customer customer) {
		try {
			String name = customer.getCustomerName();
			String address = customer.getCustomerAddress();
			String customerCEO = customer.getCustomerCEO();
			int customerABN = customer.getCustomerABN();
			double customerRate = customer.getCustomerRate();
			int NumOfPeople = customer.getNumOfPeople();
			customer.setCustomerName(name);
			customer.setCustomerAddress(address);
			customer.setCustomerCEO(customerCEO);
			customer.setCustomerABN(customerABN);
			customer.setCustomerRate(customerRate);
			customer.setCustomerRate(customerRate);
			customerRepository.editCustomer(customer);					
			
        } catch (Exception ex) {
            Logger.getLogger(CustomerManageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public Customer searchCustomerById(int id) {
		 try {
	            return customerRepository.searchCustomerById(id);
	        } catch (Exception ex) {
	            Logger.getLogger(CustomerManageBean.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return null;
	}
	//-------------------------SEARCH -------------------------------------------
	public Customer searchCustomerByName(String customerName) {
		 try {
	            return customerRepository.searchCustomerByName(customerName);
	        } catch (Exception ex) {
	            Logger.getLogger(CustomerManageBean.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return null;
	}
	
	public List<Customer> searchCustomerByName2(String customerName) {
		 try {
	            return customerRepository.searchCustomerByName2(customerName);
	        } catch (Exception ex) {
	            Logger.getLogger(CustomerManageBean.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return null;
	}
	//--------------------------------------------------------------------
	
	
	public Set<CustomerContact> searchCustomerContactByCustomer(Customer customer){
		 try {
	            return customerRepository.searchCustomerContactByCustomer(customer);
	        } catch (Exception ex) {
	            Logger.getLogger(CustomerManageBean.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return null;
	}
	
	public void addCustomer(fit5042.assignment.controllers.CustomerTemporary localCustomer) {
        //convert this newProperty which is the local property to entity property
        Customer customer = convertCustomerToEntity(localCustomer);

        try {
        	customerRepository.addCustomer(customer);;
        } catch (Exception ex) {
            Logger.getLogger(CustomerManageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	private Customer convertCustomerToEntity(fit5042.assignment.controllers.CustomerTemporary localCustomer) {
		Customer customer = new Customer();
		customer.setCustomerId(customer.getCustomerId());
		customer.setCustomerName(localCustomer.getCustomerName());
		customer.setCustomerAddress(localCustomer.getCustomerAddress());
		customer.setCustomerCEO(localCustomer.getCustomerCEO());
		customer.setCustomerABN(localCustomer.getCustomerABN());
		customer.setCustomerRate(localCustomer.getCustomerRate());
		
		int industryId = localCustomer.getIndustryId();
		String industryType = localCustomer.getIndustryType();
		Industry industry = new fit5042.assignment.repository.entities.Industry(industryId,industryType);
		if (industry.getId() == 0) {
			industry = null;
        }
		customer.setIndustry(industry);
		
		int contactId = localCustomer.getContactId();
		String contactFirstName = localCustomer.getContactFirstName();
		String contactLastName = localCustomer.getContactLastName();
		String contactEmail = localCustomer.getContactEmail();
		int contactPersonalPhone = localCustomer.getContactPersonalPhone();
		String contactGender = localCustomer.getContactGender();
		CustomerContact customerContact = new fit5042.assignment.repository.entities.CustomerContact(contactId, contactFirstName,contactLastName,contactEmail, contactPersonalPhone, contactGender);
		if (customerContact.getContactId()== 0) {
			customerContact = null;
        }
		Set<CustomerContact> customerContacts = new HashSet<CustomerContact>();
		customerContacts.add(customerContact);
		customer.setCustomerContact(customerContacts);
		
		int staffId = localCustomer.getStaffId();
		String staffName = localCustomer.getStaffName();
		Staff staff = new fit5042.assignment.repository.entities.Staff(staffId,staffName);
		if (staff.getStaffId() == 0) {
			staff = null;
        }
		customer.setStaffId(staff);
		
		return customer;
	}

	
	
	
	
	
	
}
