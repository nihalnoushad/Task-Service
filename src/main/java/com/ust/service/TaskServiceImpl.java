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
		if ((taskRepo.findById(task.getId()).isPresent())) {
			throw new TaskAlreadyExistException("Task Already Exists!");
		}

		return taskRepo.save(task);
	}

	@Override
	public Task getTaskById(Integer task_id) throws TaskNotFoundException {
		if (!(taskRepo.findById(task_id).isPresent())) {
			throw new TaskNotFoundException("Task Doesn't Exists!");
		}
		return taskRepo.findById(task_id).get();
	}

	public Task editTask(Integer task_id, Task task) throws TaskNotFoundException {
		Optional opt = taskRepo.findById(task_id);
		if (!(opt.isPresent())) {
			throw new TaskNotFoundException("Task doesn't exist");
		}
		taskRepo.save(task);
		return taskRepo.findById(task_id).get();
	}

	@Override
	public Task deleteTask(Integer task_id, Integer role_id) throws InvalidUserException {
		Task task = null;
		Optional opt = taskRepo.findById(task_id);
		if (opt.isEmpty()) {
			throw new InvalidUserException("Invalid User!");
		} else {
			task = taskRepo.findById(task_id).get();
			taskRepo.deleteById(task_id);
		}
		return null;
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}

}

