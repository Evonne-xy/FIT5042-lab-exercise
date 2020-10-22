package fit5042.assignment.repository;

import java.util.List;
import java.util.Set;
import javax.ejb.Remote;
import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.Staff;

@Remote
public interface StaffRepository {
	public List<Staff> getAllStaff() throws Exception;
	
    public void addCustomerContact(Staff staff) throws Exception;
    
    public void removeCustomerContact(int StaffId) throws Exception;
    
    public void editStaff(Staff staff) throws Exception;
    
    public Staff searchStaffById(int staffId) throws Exception;
    
    public Set<Customer> searchCustomerByStaff(Staff staff) throws Exception;

	
}
