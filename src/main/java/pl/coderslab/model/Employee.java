package pl.coderslab.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 50)
	private String firstName;

	private String secondName;

	@NotBlank
	@Size(min = 3, max = 50)
	private String lastName;

	@Column(unique = true)
	@PESEL
	private String pesel;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	@ManyToOne
	private City birthPlace;

	@Column(precision = 10, scale = 2)
	private BigDecimal salary;

	@Column(precision = 10, scale = 2)
	private BigDecimal bonus;

	@ManyToOne
	private Department department;

	@Email
	private String email;

	private String phoneNumber;

	@ManyToOne
	private TaxOffice taxOffice;

	private String bankAccountNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfEmployment;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfRelese;

	private String address1;

	private String postalCode;

	@ManyToOne
	private City city;

	@ManyToOne
	private Country country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public City getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(City birthPlace) {
		this.birthPlace = birthPlace;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public TaxOffice getTaxOffice() {
		return taxOffice;
	}

	public void setTaxOffice(TaxOffice taxOffice) {
		this.taxOffice = taxOffice;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
// datę urodzenia z numeru pesel?

// tabele z urzędami skarbowymi
// miasta
// kody pocztowe - domyślne ulice
// historia płac?
// departments