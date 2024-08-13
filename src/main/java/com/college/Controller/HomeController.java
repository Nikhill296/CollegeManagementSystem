package com.college.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.DTO.UserDetailsDto;
import com.college.Services.PrintUsersAPI;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
	Logger log = LoggerFactory.getLogger(HomeController.class); 
	
	private final PrintUsersAPI printUserApi;

	@GetMapping("")
	public String getMethodName() {
		
		log.info("------ in last attempt of welcome --------");
		return "Welcome";
	}
	
	@GetMapping("PrintUsers")
	public ResponseEntity printUsers() {
		
		log.info("------ printing users of drink water API --------");
		
		List<UserDetailsDto> detailsDtos = printUserApi.PrintUsers();
		
		return new ResponseEntity(detailsDtos, HttpStatus.FOUND);
	}

}
