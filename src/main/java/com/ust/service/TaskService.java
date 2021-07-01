package com.ust.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.exception.TaskAlreadyExistException;
import com.ust.model.Task;


public interface TaskService {
	
	
	public Task createTask(Task task) throws TaskAlreadyExistException;
	
	public Task getTaskById(Integer task_id);
	
//	public Task editTask(Integer task_id, Task task);
	
	public Task editTask(Task task);

	public void deleteTask(Integer task_id, Integer role_id);
	
    public List<Task> getAllTasks();
    
//	public Optional<Task> deleteTask(Integer id);
//	public void deleteTask(Task task);
	
	
}
