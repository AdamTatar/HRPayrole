package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.Test;
import pl.coderslab.repository.TestRepository;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestRepository testRepository;

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String addTest(Model model) {
		Test test = new Test();
		test.setName("nazwa testowa z metody addTest");
		model.addAttribute("test", test);
		testRepository.save(test);
		return "test";
	}
}
