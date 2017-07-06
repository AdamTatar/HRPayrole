package pl.coderslab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.Country;
import pl.coderslab.repository.CountryRepository;

@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryRepository countryRepository;

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String addCountry(Model model) {
		Country country = new Country();
		model.addAttribute("country", country);
		return "countryAdd";
	}
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addCountryPost(@Valid Country country, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "countryAdd";
		}
		countryRepository.save(country);
		List<Country> countries = countryRepository.findAll();
		model.addAttribute("countries", countries);
		return "countryList";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllCountries(Model model) {
		List<Country> countries = countryRepository.findAll();
		model.addAttribute("countries", countries);
		return "countryList";
	}
}
