package fit5042.assignment.repository;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.CustomerContact;


@Stateless
public class JPACustomerRepositoryImpl implements CustomerRepository{

	//insert code (annotation) here to use container managed entity manager to complete these methods
		@PersistenceContext(unitName = "fit5042Assignment-ejbPU")
	    private EntityManager entityManager;

		@Override
		public List<Customer> getAllCustomers() throws Exception {
			return entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
		}

		@Override
		public void addCustomer(Customer customer) throws Exception {
			List<Customer> customers = entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
			customer.setCustomerId(customers.get(0).getCustomerId() + 1);
	        entityManager.persist(customer);
	        entityManager.flush();
			
		}

		@Override
		public void removeCustomer(int customerId) throws Exception {
			Customer customer = this.searchCustomerById(customerId);
	         if (customer != null) {
	             entityManager.remove(customer);
	         }
			
		}

		@Override
		public void editCustomer(Customer customer) throws Exception {
			try {
	            entityManager.merge(customer);
	        } catch (Exception ex) {

	        }
			
		}
		
		@Override
		public Customer searchCustomerById(int id) throws Exception {
			Customer customers = entityManager.find(Customer.class, id);
	        return customers;
		}

		@Override
		public Set<CustomerContact> searchCustomerContactByCustomer(Customer customer) throws Exception {
			customer = entityManager.find(Customer.class, customer.getCustomerId());
			customer.getCustomerContact().size();
	        entityManager.refresh(customer);

	        return customer.getCustomerContact();
		}
		
		@Override
		public Customer searchCustomerByName (String customerName) throws Exception {
			Customer customers = entityManager.find(Customer.class, customerName);
	        return customers;
		}
		

		
}
