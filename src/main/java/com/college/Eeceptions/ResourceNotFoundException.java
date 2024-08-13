package com.college.Eeceptions;

import java.util.function.Supplier;

import lombok.AllArgsConstructor;

public class ResourceNotFoundException extends RuntimeException {

	private String resource;
	private Long resourceId;

	   public ResourceNotFoundException(String msg,Long id) {
			super(msg);
		}
}
