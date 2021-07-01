package com.ust.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.exception.TaskAlreadyExistException;
import com.ust.model.Task;
import com.ust.repository.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepo taskRepo;

	@Override
	public Task createTask(Task task) throws TaskAlreadyExistException {
		if(taskRepo.findById(task.getId())!=null)
		{
			throw new TaskAlreadyExistException("Task Already Exists!");
		}
		return taskRepo.save(task);
	}


	@Override
	public Task getTaskById(Integer task_id) {
		return taskRepo.findById(task_id).get();
	}
	
/*	@Override
	public Task editTask(Integer task_id, Task task ) {
		
		taskRepo.save(task);
		return taskRepo.findById(task_id).get();
	}
*/
	
	@Override
	public Task editTask(Task task) {
		return taskRepo.save(task);
//		return taskRepo.getById(id);
	}
		
	
	@Override
	public void deleteTask(Integer task_id, Integer role_id) {
		taskRepo.deleteById(task_id);
		
	}
	
	@Override
	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}
	
	
	
/*	@Override
	public void deleteTask(Integer id) {
		Task task = this.getTaskById(id);
		taskRepo.delete(task);
		
	}
	
	@Override
	public Task editTask(Task task) {
		return taskRepo.save(task);
	}
	
	@Override
	public Optional<Task> deleteTask(Integer id) {
		return null;
	}
	
*/
	
	
	
	
	

}
