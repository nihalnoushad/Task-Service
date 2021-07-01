package com.ust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
	
	
	
	

}
