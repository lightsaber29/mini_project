package kosta.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "main";
	}
	
	@RequestMapping("/index")	
	public String indexMapping() {
		return "index";
	}
}
