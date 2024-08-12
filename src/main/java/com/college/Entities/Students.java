package com.college.Entities;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;

import com.college.Entities.AdmissionRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "stusents_professors")
	private List<Professors> professors;
	
	@ManyToMany( fetch = FetchType.LAZY)
	@JoinTable(name = "stusents_subjects")
	private List<Subjects> subjects;

	@OneToOne(mappedBy = "student")
	@Cascade(CascadeType.ALL)
//	@JsonIgnore
	private AdmissionRecord admissiom;
}
