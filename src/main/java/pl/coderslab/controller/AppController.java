package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String addCompanyPost(User user, Model model) {
		User loginUser = userRepository.findUserByNick(user.getNick());
		
		if ((user.getNick()).equals(loginUser.getNick()) && (user.getPassword()).equals(loginUser.getPassword())) {
			return "welcome";
		}
		return "login";
	}

	
}
