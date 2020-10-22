package fit5042.assignment.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fit5042.assignment.repository.entities.Administrator;
import fit5042.assignment.repository.entities.Customer;

public class JPAAdminREpositoryImpl implements AdministratorRepository{
	
	@PersistenceContext(unitName = "fit5042Assignment-ejbPU")
    private EntityManager entityManager;

	@Override
	public List<Administrator> getAllAdministrator() throws Exception {
		return entityManager.createNamedQuery(Administrator.GET_ALL_QUERY_NAME).getResultList();
	}

	@Override
	public void addAdministrator(Administrator administrator) throws Exception {
		List<Administrator> administrators = entityManager.createNamedQuery(Administrator.GET_ALL_QUERY_NAME).getResultList();
		administrator.setAdminId(administrators.get(0).getAdminId() + 1);
        entityManager.persist(administrator);
        entityManager.flush();
		
	}

	@Override
	public void removeAdministrator(int administratorId) throws Exception {
		Administrator administrator = this.searchAdministratorById(administratorId);
        if (administrator != null) {
            entityManager.remove(administrator);
        }
		
	}

	@Override
	public void editAdministrator(Administrator administrator) throws Exception {
		try {
            entityManager.merge(administrator);
        } catch (Exception ex) {

        }
		
	}

	@Override
	public Administrator searchAdministratorById(int administratorId) throws Exception {
		Administrator administrators = entityManager.find(Administrator.class, administratorId);
        return administrators;
	}

}
