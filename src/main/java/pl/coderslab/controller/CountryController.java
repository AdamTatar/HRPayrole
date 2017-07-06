package pl.coderslab.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.City;
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

	@RequestMapping(path = "/addFromFile",method = RequestMethod.GET)
	public String addListOfCountriesFromFile() {
		try {
			List<String> countriesString = Files.readAllLines(Paths.get("countries.txt"));
			List<Country> countries = new ArrayList<>();
			for(Integer i = 0; i < countriesString.size();i++) {
				Country country = new Country();
				country.setName(countriesString.get(i).substring(1));
				countries.add(country);
			}
			countryRepository.save(countries);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "countryList";
	}
}
