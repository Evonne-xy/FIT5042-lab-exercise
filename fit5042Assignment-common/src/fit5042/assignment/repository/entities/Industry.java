package fit5042.assignment.repository.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "INDUSTRY")
@NamedQueries({
    @NamedQuery(name = Industry.GET_ALL_QUERY_NAME, query = "SELECT i FROM Industry i")})
public class Industry implements Serializable{
	
	public static final String GET_ALL_QUERY_NAME = "Industry.getAll";
	private int industryId;
	private String industryType;
	private Set<Customer> customers;

	
	public Industry() {
		
	}

	public Industry(int industryId, String industryType) {
		this.industryId = industryId;
		this.industryType = industryType;
		this.customers = new HashSet<>();
	}
	
	@Id
    @GeneratedValue
	@Column(name = "industry_id")
	public int getId() {
		return industryId;
	}

	public void setId(int industryId) {
		this.industryId = industryId;
	}

	@Column(name = "industry_type")
	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	
	//Each customer has one and only one industry. 
    //Each Industry might be responsible for zero to many customer
	@OneToMany (mappedBy = "Industry")
	public Set<Customer> getCustomer() {
		return customers;
	}

	public void setCustomer(Set<Customer> customers) {
		this.customers = customers;
	}

	
	
	

}

