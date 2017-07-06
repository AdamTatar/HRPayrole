package pl.coderslab.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

@Entity
@Table(name = "companies")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String companyName;

	private String companyAddress1;

	private String companyAddress2;
	
	@ManyToOne
	private	Country country;

	@ManyToOne
	private	City city;

	@NIP
	private String companyNip;

	@REGON
	private String companyRegon;

	private String companyPhone;

	private String companyFax;

	private String companyBankAccountNumber;
	
	
	//getters and setters


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress1() {
		return companyAddress1;
	}

	public void setCompanyAddress1(String companyAddress1) {
		this.companyAddress1 = companyAddress1;
	}

	public String getCompanyAddress2() {
		return companyAddress2;
	}

	public void setCompanyAddress2(String companyAddress2) {
		this.companyAddress2 = companyAddress2;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getCompanyNip() {
		return companyNip;
	}

	public void setCompanyNip(String companyNip) {
		this.companyNip = companyNip;
	}

	public String getCompanyRegon() {
		return companyRegon;
	}

	public void setCompanyRegon(String companyRegon) {
		this.companyRegon = companyRegon;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyFax() {
		return companyFax;
	}

	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}

	public String getCompanyBankAccountNumber() {
		return companyBankAccountNumber;
	}

	public void setCompanyBankAccountNumber(String companyBankAccountNumber) {
		this.companyBankAccountNumber = companyBankAccountNumber;
	}

		

	
	
	
	
	
	
	
}
