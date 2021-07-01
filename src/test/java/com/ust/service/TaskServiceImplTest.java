package com.ust.service;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.ust.exception.InvalidUserException;
import com.ust.exception.TaskAlreadyExistException;
import com.ust.exception.TaskNotFoundException;
import com.ust.model.Task;
import com.ust.repository.TaskRepo;

@RunWith(MockitoJUnitRunner.class)
class TaskServiceImplTest {

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		task = new Task(1, 1,"njnjn","sbbfff", "2020-12-20", "2021-02-15");
		optional = Optional.of(task);
	}
	
	@AfterEach
	public void tearDown() {
		task = null;
	}

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private TaskRepo taskRepo;

	@InjectMocks
	private TaskServiceImpl taskService;
	private Task task;
	private Optional optional;
	
	
	@Test
	public void createTaskThenShouldReturnTask() throws TaskAlreadyExistException{
		when(taskRepo.save(any())).thenReturn(task);
        assertEquals(task, taskService.createTask(task));
        verify(taskRepo, times(1)).save(task);
	}
	
	@Test
	public void createTaskThenShouldNotReturnTask() throws TaskAlreadyExistException {
       when(taskRepo.save(task)).thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class, () -> taskService.createTask(task));
	}
	
	@Test
	public void getTaskThenShouldReturnTask() throws TaskNotFoundException {
		 when(taskRepo.findById(anyInt())).thenReturn(Optional.of(task));
	        Task retrievedTask = taskService.getTaskById(task.getId());
	        verify(taskRepo, times(2)).findById(anyInt());
	}
	
	@Test
	void givenTaskIdToDeleteThenShouldDeleteRespectiveTask() throws InvalidUserException {
		when(taskRepo.findById(task.getId())).thenReturn(optional);
		Task deletedTask = taskService.deleteTask(1, 1);
		verify(taskRepo, times(2)).findById(task.getId());
		verify(taskRepo, times(1)).deleteById(task.getId());
	}

	@Test
	void givenTaskIdToDeleteThenShouldNotReturnDeletedTask() throws InvalidUserException {
		when(taskRepo.findById(task.getId())).thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class, () ->
               taskService.deleteTask(1, 1));
        verify(taskRepo, times(1)).findById(task.getId());

	}
	
	@Test
    public void givenTaskToEditThenShouldReturnEditedTask() throws TaskNotFoundException {
        when(taskRepo.findById(task.getId())).thenReturn(Optional.of(task));
        when(taskRepo.save(task)).thenReturn(task);
        task.setId(1);
        task.setRole_id(1);
        task.setTask_start_date("2020-12-12");
        task.setTask_end_date("2020-12-12");
        task.setTask_name("vcv");
        task.setTask_Descreption("sfvfvf");
        Task task1 = taskService.editTask(task.getId(),task);
        assertEquals(task1.getId(), 1);
        assertEquals(task1.getRole_id(), 1);
        assertEquals(task1.getTask_start_date(), "2020-12-12");
        assertEquals(task1.getTask_end_date(), "2020-12-12");
        verify(taskRepo, times(1)).save(task);

    }

    @Test
    public void givenTaskToEditThenShouldNotReturnEditedTask() throws TaskNotFoundException {
        when(taskRepo.existsById(task.getId())).thenReturn(false);
        Assertions.assertThrows(TaskNotFoundException.class, () ->
        taskService.editTask(1, task));
    }




}








//verify(taskRepo, times(1)).findById(task.getId());