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
import pl.coderslab.model.TaxOffice;
import pl.coderslab.repository.TaxOfficeRepository;

@Controller
@RequestMapping("/taxOffice")
public class TaxOfficeController {

	@Autowired
	private TaxOfficeRepository taxOfficeRepository;

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String addTaxOffice(Model model) {
		TaxOffice taxOffice = new TaxOffice();
		model.addAttribute("taxOffice", taxOffice);
		return "taxOfficeAdd";
	}
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addTaxOfficePost(@Valid TaxOffice taxOffice, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "taxOfficeAdd";
		}
		taxOfficeRepository.save(taxOffice);
		List<TaxOffice> taxOffices = taxOfficeRepository.findAll();
		model.addAttribute("taxOffices", taxOffices);
		return "taxOfficeList";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllCountries(Model model) {
		List<TaxOffice> taxOffices = taxOfficeRepository.findAll();
		model.addAttribute("taxOffices", taxOffices);
		return "taxOfficeList";
	}
	
	
	@RequestMapping(path = "/addFromFile",method = RequestMethod.GET)
	public String addListOfTaxOfficesFromFile() {
		try {
			List<String> officesString = Files.readAllLines(Paths.get("taxOffices.txt"));
			List<TaxOffice> taxOffices = new ArrayList<>();
			for(Integer i = 0; i < officesString.size();i++) {
				TaxOffice taxOffice = new TaxOffice();
				taxOffice.setName(officesString.get(i));
				taxOffices.add(taxOffice);
			}
			taxOfficeRepository.save(taxOffices);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "taxOfficeList";
	}
	
	
	
	
}
	

