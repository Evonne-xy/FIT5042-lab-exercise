package fit5042.assignment.repository;

import java.util.List;
import javax.ejb.Remote;
import fit5042.assignment.repository.entities.Administrator;


@Remote
public interface AdministratorRepository {

	public List<Administrator> getAllAdministrator() throws Exception;
	
    public void addAdministrator(Administrator administrator) throws Exception;
    
    public void removeAdministrator(int administratorId) throws Exception;
    
    public void editAdministrator(Administrator administrator) throws Exception;
    
    public Administrator searchAdministratorById(int administratorId) throws Exception;
    
    
}
