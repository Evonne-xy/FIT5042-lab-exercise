package fit5042.assignment.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.Staff;

public class JPAStaffRepositoryImpl implements StaffRepository{
	
	@PersistenceContext(unitName = "fit5042Assignment-ejbPU")
    private EntityManager entityManager;

	@Override
	public List<Staff> getAllStaff() throws Exception {
		return entityManager.createNamedQuery(Staff.GET_ALL_QUERY_NAME).getResultList();
	}

	@Override
	public void addCustomerContact(Staff staff) throws Exception {
		List<Staff> staffs = entityManager.createNamedQuery(Staff.GET_ALL_QUERY_NAME).getResultList();
		staff.setStaffId(staffs.get(0).getStaffId() + 1);
        entityManager.persist(staff);
        entityManager.flush();
		
	}

	@Override
	public void removeCustomerContact(int StaffId) throws Exception {
		Staff staff = this.searchStaffById(StaffId);
        if (staff != null) {
            entityManager.remove(StaffId);
        }
		
	}

	@Override
	public void editStaff(Staff staff) throws Exception {
		try {
            entityManager.merge(staff);
        } catch (Exception ex) {

        }
		
	}

	@Override
	public Staff searchStaffById(int staffId) throws Exception {
		Staff staffs = entityManager.find(Staff.class, staffId);
        return staffs;
	}

	@Override
	public Set<Customer> searchCustomerByStaff(Staff staff) throws Exception {
		staff = entityManager.find(Staff.class, staff.getStaffId());
		staff.getCustomerMangement().size();
        entityManager.refresh(staff);

        return staff.getCustomerMangement();
	}

}
