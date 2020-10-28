package fit5042.assignment.repository;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.CustomerContact;



@Stateless
public class JPACustomerContactRepositoryImpl implements CustomerContactRepository{

	//insert code (annotation) here to use container managed entity manager to complete these methods
			@PersistenceContext(unitName = "fit5042Assignment-ejbPU")
		    private EntityManager entityManager;
	
	@Override
	public List<CustomerContact> getAllCustomerContact() throws Exception {
		return entityManager.createNamedQuery(CustomerContact.GET_ALL_QUERY_NAME).getResultList();
	}


	@Override
	public void addCustomerContact(CustomerContact customerContact) throws Exception {
		List<CustomerContact> customerContacts = entityManager.createNamedQuery(customerContact.GET_ALL_QUERY_NAME).getResultList();
		customerContact.setContactId(customerContacts.get(0).getContactId() + 1);
		Customer customer = customerContact.getCustomer();
		customer.getCustomerContact().add(customerContact);		
        entityManager.merge(customer);
        entityManager.persist(customerContact);
        entityManager.flush();	
	}

	@Override
	public void removeCustomerContact(int customerContactId) throws Exception {
		CustomerContact customerContact = this.searchCustomerContactById(customerContactId);
        if (customerContact != null) {
        	Customer customer = customerContact.getCustomer();
        	customer.getCustomerContact().remove(customerContact);
        	entityManager.merge(customer);
            entityManager.remove(customerContact);
            entityManager.flush();	
        }
		
	}

	@Override
	public void editCustomerContact(CustomerContact customerContact) throws Exception {
		try {
            entityManager.merge(customerContact);
        } catch (Exception ex) {

        }
		
	}

	@Override
	public CustomerContact searchCustomerContactById(int customerContactId) throws Exception {
		CustomerContact customerContact = entityManager.find(CustomerContact.class, customerContactId);
		return customerContact;
	}

	@Override
    public Customer searchCustomerByContactPerson(CustomerContact customerContact) throws Exception {
		customerContact = entityManager.find(CustomerContact.class, customerContact.getContactId());
		customerContact.getCustomer();
        entityManager.refresh(customerContact);

        return customerContact.getCustomer();
    }


		

		
}
