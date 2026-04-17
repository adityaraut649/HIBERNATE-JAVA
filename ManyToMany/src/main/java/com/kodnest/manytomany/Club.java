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

@Entity
@Table
public class Club {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String club_name;

	@ManyToMany(mappedBy = "clubs")
	List<Student> students;

	public Club(String club_name) {
	    this.club_name = club_name;
	}

	public Club(String club_name, List<Student> students) {
		super();
		this.club_name = club_name;
		this.students = students;
	}

	public Club(int id, String club_name, List<Student> students) {
		super();
		this.id = id;
		this.club_name = club_name;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Club [id=" + id + ", club_name=" + club_name + "]";
	}

}
