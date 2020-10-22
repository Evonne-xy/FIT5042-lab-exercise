package fit5042.assignment.repository;

import java.util.List;

import javax.ejb.Remote;

import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.CustomerContact;

@Remote
public interface CustomerContactRepository {

		public List<CustomerContact> getAllCustomerContact() throws Exception;
		
	    public void addCustomerContact(CustomerContact customerContact) throws Exception;
	    
	    public void removeCustomerContact(int customerContactId) throws Exception;
	    
	    public void editCustomerContact(CustomerContact customerContact) throws Exception;
	    
	    public CustomerContact searchCustomerContactById(int customerContactId) throws Exception;
	    
	    public Customer searchCustomerByContactPerson(CustomerContact customerContact) throws Exception;
}
