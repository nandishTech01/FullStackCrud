package com.AngularDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AngularDemo.Entity.AngularUser;

@Repository
public interface Userrepository extends JpaRepository<AngularUser, Integer>{

	
}
