package com.college.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
public class HomeController {
	Logger log = LoggerFactory.getLogger(HomeController.class); 

	@GetMapping("")
	public String getMethodName() {
		
		log.info("------ in last attempt of welcome --------");
		return "Welcome";
	}
	

}
