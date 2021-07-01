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

	public Task editTask(Integer task_id, Task task) throws TaskNotFoundException;

	public Task deleteTask(Integer task_id, Integer role_id) throws InvalidUserException;

	public List<Task> getAllTasks();

}
