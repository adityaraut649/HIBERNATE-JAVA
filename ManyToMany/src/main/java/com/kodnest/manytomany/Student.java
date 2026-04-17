package com.kodnest.manytomany;

import java.util.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String name;
	@Column
	String email;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_club", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "club_id"))
	List<Club> clubs;

	public Student(String name, String email) {
	    this.name = name;
	    this.email = email;
	}

	public Student(int id, String name, String email, List<Club> clubs) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.clubs = clubs;
	}

	public Student(String name, String email, List<Club> clubs) {
		super();
		this.name = name;
		this.email = email;
		this.clubs = clubs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Club> getClubs() {
		return clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
