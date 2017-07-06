package pl.coderslab.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employeeDetails")
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfEmployment;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfRelese;

	@Max(255)
	private String address1;

	@Max(255)
	private String address2;

	private String postalCode;

	@ManyToOne
	private	Country country;

	@ManyToOne
	private	City city;

	@Email
	private String email;

	private String phoneNumber;

	private String partnersName;

	private String partnersLastName;

	private String children;

	private String taxOfficeAddress;

	private String bankAccountNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	public Date getDateOfRelese() {
		return dateOfRelese;
	}

	public void setDateOfRelese(Date dateOfRelese) {
		this.dateOfRelese = dateOfRelese;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPartnersName() {
		return partnersName;
	}

	public void setPartnersName(String partnersName) {
		this.partnersName = partnersName;
	}

	public String getPartnersLastName() {
		return partnersLastName;
	}

	public void setPartnersLastName(String partnersLastName) {
		this.partnersLastName = partnersLastName;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getTaxOfficeAddress() {
		return taxOfficeAddress;
	}

	public void setTaxOfficeAddress(String taxOfficeAddress) {
		this.taxOfficeAddress = taxOfficeAddress;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}


	
	
}
