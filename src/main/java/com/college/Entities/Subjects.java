package com.college.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Subjects {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String title;
	
	private Integer marks;

	private String stdcount;
	
	@ManyToMany(mappedBy = "subjects", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Students> students;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subjects")
	@JsonIgnore
	private Professors professors;
	
}
