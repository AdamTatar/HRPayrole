package pl.coderslab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.City;
import pl.coderslab.model.Company;
import pl.coderslab.model.Country;
import pl.coderslab.repository.CityRepository;
import pl.coderslab.repository.CompanyRepository;
import pl.coderslab.repository.CountryRepository;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CityRepository cityRepository;

	@ModelAttribute("countries")
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@ModelAttribute("cities")
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String addCompany(Model model) {
		Company company = new Company();
		model.addAttribute("company", company);
		return "companyAdd";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addCompanyPost(@Valid Company company, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "companyAdd";
		}
		companyRepository.save(company);
		List<Company> companies = companyRepository.findAll();
		model.addAttribute("companies", companies);
		return "companyList";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllCountries(Model model) {
		List<Company> companies = companyRepository.findAll();
		Company company = companyRepository.findOne(1L);
		model.addAttribute("companies", companies);
		model.addAttribute("company", company);
		return "companyList";
	}
}
