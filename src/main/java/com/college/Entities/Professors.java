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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@ToString
public class Professors {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String title;

	@ManyToMany(mappedBy = "professors", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Students> students; 
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name="Professors_Subjects")
	@Cascade(CascadeType.ALL)
	private List<Subjects> subjects;
	
}
