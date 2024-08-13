package com.college.Service.ServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.college.Controller.HomeController;
import com.college.DTO.UserDetailsDto;
import com.college.Services.PrintUsersAPI;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RequiredArgsConstructor
@Service
public class PrintUsersApiImpl implements PrintUsersAPI{
	Logger log = LoggerFactory.getLogger(PrintUsersApiImpl.class); 

	private final RestClient restClient;

	@Override
	public List<UserDetailsDto> PrintUsers() {
		// TODO Auto-generated method stub
		List<UserDetailsDto> userDetailsDtoList = 
				restClient.get()
					.uri("/UserAPI/Users/getUsers")
					.retrieve()
					.body(new ParameterizedTypeReference<>() {
						
					});
				
				
	 log.info(" the users are "+ userDetailsDtoList.toString());
		
		return userDetailsDtoList;
	}

}
