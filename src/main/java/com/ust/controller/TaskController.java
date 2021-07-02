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

import com.ust.exception.InvalidUserException;
import com.ust.exception.TaskAlreadyExistException;
import com.ust.exception.TaskNotFoundException;
import com.ust.model.Task;
import com.ust.service.TaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/app/task")
@RestController
@Api
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@PostMapping("/create-task")
	public ResponseEntity<?> createTask(@RequestBody Task task) {
		try {
			return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
		} catch (TaskAlreadyExistException te) {
			return new ResponseEntity<String>(te.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/retrieve-task")
	public ResponseEntity<?> getTaskById(@RequestParam Integer task_id) {
		try {
			return new ResponseEntity<>(taskService.getTaskById(task_id), HttpStatus.FOUND);
		} catch (TaskNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	
	@PutMapping("/edit-task/{task_id}")
	public ResponseEntity<?> editTask(@PathVariable Integer task_id, @RequestBody Task task) {
		
		try {
			return new ResponseEntity<Task>(taskService.editTask(task_id, task), HttpStatus.OK);
		} catch (TaskNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}

	}

	@DeleteMapping("/delete-task")

	public ResponseEntity<String> deleteTask(@RequestParam Integer task_id, Integer role_id) {
		try {
			taskService.deleteTask(task_id, role_id);
			return new ResponseEntity<String>("Successfully Deleted  the Task " + task_id, HttpStatus.OK);
		} catch (InvalidUserException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

}



