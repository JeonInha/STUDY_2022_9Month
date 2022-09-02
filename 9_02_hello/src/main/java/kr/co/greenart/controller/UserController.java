package kr.co.greenart.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.greenart.model.User;

@Controller
public class UserController {
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
//	@Autowired
//	private UserValidator validator;
	
	@ModelAttribute("user")
	public User user() {
		return new User("기본값", 1);
	}
	
	@GetMapping("/user")
	public String userForm(@ModelAttribute("user") User user) {
		return "userForm";
	}
	
	@PostMapping("/user")
	public String submit(@ModelAttribute("user") @Valid User user, BindingResult errors) {
		logger.info("입력 정보: " + user.toString());

//		validator.validate(user, errors);
		
		if (errors.hasErrors()) {
			logger.info(errors.toString());
			return "userForm";
		}
		
		return "redirect:/";
	}
}








