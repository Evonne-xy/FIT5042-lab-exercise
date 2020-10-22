package fit5042.assignment.repository;

import java.util.List;
import java.util.Set;
import javax.ejb.Remote;
import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.CustomerContact;


@Remote
public interface CustomerRepository {

    public List<Customer> getAllCustomers() throws Exception;
	
    public void addCustomer(Customer customer) throws Exception;
    
    public void removeCustomer(int customerId) throws Exception;
    
    public void editCustomer(Customer customer) throws Exception;
    
    public Customer searchCustomerById(int id) throws Exception;
    
    public Set<CustomerContact> searchCustomerContactByCustomer(Customer customer) throws Exception;
    
    public Customer searchCustomerByName (String customerName) throws Exception;
    
   
    
}
