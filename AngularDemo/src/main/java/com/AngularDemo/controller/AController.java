package com.AngularDemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AngularDemo.Entity.AngularUser;
import com.AngularDemo.Exception.ResourceNotFoundException;
import com.AngularDemo.Repository.Userrepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AController {

	@Autowired
	private Userrepository userrepository;

	@GetMapping("/employees")
	public List<AngularUser> allusers() {
		return userrepository.findAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<AngularUser> getUserById(@PathVariable(value = "id") int userid) {
		AngularUser user = new AngularUser();
		userrepository.findById(userid);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/employees")
	public AngularUser createUser(@RequestBody AngularUser angularUser) {
		return userrepository.save(angularUser);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<AngularUser> updateuser(@PathVariable(value = "id") int empid,
			@RequestBody AngularUser userdetail) {

		AngularUser au = userrepository.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empid));

		au.setUsername(userdetail.getUsername());
		au.setMobile(userdetail.getMobile());
		au.setPassword(userdetail.getPassword());
		au.setAddress(userdetail.getAddress());
		final AngularUser updatedUser = userrepository.save(au);
		return ResponseEntity.ok(updatedUser);
	}

	
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteuser(@PathVariable(value = "id") int userid) {

		AngularUser au = userrepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userid));
		userrepository.delete(au);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}

}
