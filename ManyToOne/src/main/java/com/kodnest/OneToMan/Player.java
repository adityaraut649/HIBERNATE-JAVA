package com.kodnest.OneToMan;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "player")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;
	@Column
	String pname;
	@Column
	String email;
	@Column
	String phone;
	@Column
	float height;
	@OneToMany(mappedBy = "player", cascade = CascadeType.ALL)

	List<Game> Games;

	public Player(String string, String string2, String string3, float f) {
		// TODO Auto-generated constructor stub
	}

	public Player(int pid, String pname, String email, String phone, float height, List<Game> games) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.email = email;
		this.phone = phone;
		this.height = height;
		Games = games;
	}

	public Player(String pname, String email, String phone, float height, List<Game> games) {
		super();
		this.pname = pname;
		this.email = email;
		this.phone = phone;
		this.height = height;
		Games = games;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public List<Game> getGames() {
		return Games;
	}

	public void setGames(List<Game> games) {
		Games = games;
	}

	@Override
	public String toString() {
		return "Player [pid=" + pid + ", pname=" + pname + ", email=" + email + ", phone=" + phone + ", height="
				+ height + ", Games=" + Games + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Games, email, height, phone, pid, pname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(Games, other.Games) && Objects.equals(email, other.email)
				&& Float.floatToIntBits(height) == Float.floatToIntBits(other.height)
				&& Objects.equals(phone, other.phone) && pid == other.pid && Objects.equals(pname, other.pname);
	}

}
