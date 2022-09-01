package kr.co.greenart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// "/print" GET 요청 -> text입력가능폼(form.jsp)으로 foward
// "/print" post 요청 -> submit시 "/print" POST요청 -> 입력한 text 그대로를 볼수있는 (view) print.jsp로 foward


@Controller
public class PrintController {
	
	private final static Logger logger = LoggerFactory.getLogger(RequestHandling.class);
	
	@RequestMapping(value = "/print", method=RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	@RequestMapping(value = "/print", method=RequestMethod.POST)
	public String submit(@RequestParam String text, Model model) {
		model.addAttribute("result", text);
		return "print";
	}
}
