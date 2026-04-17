package com.kodnest.OnetoOne;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
(name = "kodneststudent")
public class Kodneststudent {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
     int sid;
	@Column
     String name;
	@Column
     String email;
	@Column
     String phone;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
     Address address;
     
     public Kodneststudent() {
		// TODO Auto-generated constructor stub
	}

	 public Kodneststudent(int sid, String name, String email, String phone, Address address) {
		super();
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	 }

	 public Kodneststudent(String name, String email, String phone, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	 }

	 public int getSid() {
		 return sid;
	 }

	 public void setSid(int sid) {
		 this.sid = sid;
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

	 public String getPhone() {
		 return phone;
	 }

	 public void setPhone(String phone) {
		 this.phone = phone;
	 }

	 public Address getAddress() {
		 return address;
	 }

	 public void setAddress(Address address) {
		 this.address = address;
	 }

	 @Override
	 public String toString() {
		return "Kodneststudent [sid=" + sid + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + "]";
	 }

	 @Override
	 public int hashCode() {
		return Objects.hash(address, email, name, phone, sid);
	 }

	 @Override
	 public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kodneststudent other = (Kodneststudent) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone) && sid == other.sid;
	 }
	 
	 
     
     
}
