package com.AngularDemo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AngularUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String username;
	
	private String password;
	
	private String address;
	
	private String mobile;

	@Override
	public String toString() {
		return "AngularUser [id=" + id + ", username=" + username + ", password=" + password + ", address=" + address
				+ ", mobile=" + mobile + "]";
	}
	
}
