
package fit5042.tutex.calculator;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.Remote;

import fit5042.tutex.repository.entities.Property;

/**
 *
 * @author Messom
 * @author Elliot
 */
@Remote
public interface CompareProperty {

    void addProperty(Property property);

    void removeProperty(Property property);
    
    int bestPerRoom();

    CompareProperty create() throws CreateException, RemoteException;
    
}