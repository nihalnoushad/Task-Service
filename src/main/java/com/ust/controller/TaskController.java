package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.exception.TaskAlreadyExistException;
import com.ust.model.Task;
import com.ust.service.TaskService;

@RequestMapping("/app/task")
@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	
	@PostMapping("/create-task")
	public ResponseEntity<Task> createTask(@RequestBody Task task) throws TaskAlreadyExistException {
		
//	        Task createTask = taskService.createTask(task);
//	       if(createTask.equals(null)) {
//	            throw new TaskAlreadyExistException();
//	        }
		return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
//		return new ResponseEntity<>(createTask, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/retrieve-task")
	public ResponseEntity<Task> getTaskById(@RequestParam Integer task_id) {
		return new ResponseEntity<>(taskService.getTaskById(task_id), HttpStatus.FOUND);
		
	}
	
/*	@PutMapping("/edit-task")
	public ResponseEntity<Task> editTask(@RequestParam Integer task_id, Task task ) {
		return new ResponseEntity<>(taskService.editTask(task_id, task), HttpStatus.OK);
		
	}
*/	
	
	@PutMapping("/edit-task")
	public ResponseEntity<Task> editTask(@RequestBody Task task ) {
		return new ResponseEntity<>(taskService.editTask(task), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete-task")
	public ResponseEntity<String> deleteTask(@RequestParam Integer task_id, Integer role_id) {
		taskService.deleteTask(task_id, role_id);
		return new ResponseEntity<String>("Successfully Deleted  the Task " + task_id, HttpStatus.OK);
	}
	
	
	
	

}
