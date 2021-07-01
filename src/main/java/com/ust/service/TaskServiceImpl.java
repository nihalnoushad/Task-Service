package com.ust.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.exception.InvalidUserException;
import com.ust.exception.TaskAlreadyExistException;
import com.ust.exception.TaskNotFoundException;
import com.ust.model.Task;
import com.ust.repository.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepo taskRepo;

	@Override
	public Task createTask(Task task) throws TaskAlreadyExistException {
		

		return taskRepo.save(task);
	}



	@Override
	public Task getTaskById(Integer task_id) throws TaskNotFoundException {
		if (!(taskRepo.findById(task_id).isPresent())) {
			throw new TaskNotFoundException("Task Doesn't Exists!");
		}
		return taskRepo.findById(task_id).get();
	}
	

	
	@Override
	public Task editTask(Task task)  {
		return taskRepo.save(task);
	}

		
	
	@Override
	public void deleteTask(Integer task_id, Integer role_id) throws InvalidUserException {
		Task task=null;
		Optional opt=taskRepo.findById(task_id);
		if(opt.isEmpty()) {
			throw new InvalidUserException("Invalid User!");
		}
		else{
			task=taskRepo.findById(task_id).get();
			taskRepo.deleteById(task_id);
		}
	}
	
	@Override
	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}
	
	
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
	
	
//	public Task editTask(Integer task_id,Integer role_id) throws InvalidUserException {
//	Task task=taskRepo.findById(task_id).get();
//	if(task==null) {
//		throw new InvalidUserException("Invalid User!");
//	}
//	else {
//		return task;
//	}
//}	
	
//	public void deleteTask(Integer task_id, Integer role_id) {
//	taskRepo.deleteById(task_id);
//	
//}
	/*	@Override
	public Task editTask(Integer task_id, Task task ) {
		
		taskRepo.save(task);
		return taskRepo.findById(task_id).get();
	}
*/
	
	/*		if(taskRepo.findById(task.getId())!=null)
	{
		throw new TaskAlreadyExistException("Task Already Exists!");
	}
*/	
	
//    if(!((taskRepo.findById(task.getId())==null))) {
//    
//    throw new TaskAlreadyExistException("Task Already Exists!");
//} 	
