package fit5042.tutex.calculator;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.CreateException;
import javax.ejb.Stateful;

import fit5042.tutex.repository.entities.Property;


@Stateful
public class ComparePropertySessionBean implements CompareProperty{

	private Set<Property> propertyList;
	
	public ComparePropertySessionBean() {
		propertyList = new HashSet<Property>();
	}
	
	@Override
	public void addProperty(Property property) {
		propertyList.add(property);
	}

	@Override
	public void removeProperty(Property property) {
		for (Property p : propertyList) {
    		if (p.getPropertyId() == property.getPropertyId()) {
    			propertyList.remove(p);
    			break;
    		}
    	}
	}

	@Override
	public int bestPerRoom() {
		int bestRoomId = 0;
		double bestComparePrice = 10000000000000000.00;
		for (Property p : propertyList) {
			if(p.getPrice()/p.getNumberOfBedrooms() < bestComparePrice) {
				bestComparePrice = p.getPrice()/p.getNumberOfBedrooms();
				bestRoomId = p.getPropertyId();
			}
			
		}
		
		return bestRoomId;
	}

	/**
    *
    * @return 
    * @throws javax.ejb.CreateException
    * @throws java.rmi.RemoteException
    */
   @PostConstruct
   public void init() {
	   propertyList = new HashSet<>();
   }

   public CompareProperty create() throws CreateException, RemoteException {
       return null;
   }

   public void ejbCreate() throws CreateException {
   }

	

    
}
