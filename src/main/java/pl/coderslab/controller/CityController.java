package pl.coderslab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.City;
import pl.coderslab.repository.CityRepository;

@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityRepository cityRepository;

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String addCity(Model model) {
		City city = new City();
		model.addAttribute("city", city);
		return "cityAdd";
	}
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addCityPost(@Valid City city, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "cityAdd";
		}
		cityRepository.save(city);
		List<City> cities = cityRepository.findAll();
		model.addAttribute("cities", cities);
		return "cityList";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllCountries(Model model) {
		List<City> cities = cityRepository.findAll();
		model.addAttribute("cities", cities);
		return "cityList";
	}
}
	

