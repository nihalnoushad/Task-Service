package com.ust.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.exception.InvalidUserException;
import com.ust.exception.TaskAlreadyExistException;
import com.ust.exception.TaskNotFoundException;
import com.ust.model.Task;


public interface TaskService {
	
	
	public Task createTask(Task task) throws TaskAlreadyExistException;
	
	public Task getTaskById(Integer task_id) throws TaskNotFoundException;
	

	
	public Task editTask(Task task) throws InvalidUserException;
	
	public void deleteTask(Integer task_id, Integer role_id) throws InvalidUserException;
	
	public List<Task> getAllTasks(); 
//	public void deleteTask(Integer role_id) throws InvalidUserException;
//	public Task editTask(Integer task_id, Integer role_id) throws InvalidUserException;
    
//	public Optional<Task> deleteTask(Integer id);
//	public void deleteTask(Task task);
	
	
}
