package com.college.Advices;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.DeclareAnnotation;
import org.hibernate.grammars.hql.HqlParser.LocalDateTimeContext;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
public class ApiResponce<T> {

	private T data;
	private LocalDateTime timestamp;
	private ApiError apiError;
	
	public ApiResponce() {this.timestamp=LocalDateTime.now();}
	
	public ApiResponce(T data) {
		this();
		this.data=data;
	}
	
	public ApiResponce(ApiError apiError) {
		this();
		this.apiError=apiError;
	}
	
}
