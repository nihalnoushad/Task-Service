package com.ust.controller;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;
import com.ust.exception.TaskAlreadyExistException;
import com.ust.model.Task;
import com.ust.service.TaskService;

@RunWith(SpringRunner.class)
@WebMvcTest
class TaskControllerTest {

	@Autowired
	private MockMvc mock;

	@MockBean
	private TaskService taskService;

	@InjectMocks
	private TaskController taskController;

	private Task task;

	public static Task getTask() {
		Task tempTask = new Task();

		tempTask.setTask_name("book");
		tempTask.setRole_id(1);
		tempTask.setId(1);
		tempTask.setTask_start_date("2021-06-28");
		tempTask.setTask_end_date("2021-06-30");
		tempTask.setTask_Descreption("hghb");
		return tempTask;
	}

	
	@Test
	public void testCreateTask() throws Exception {

		mock.perform(MockMvcRequestBuilders.post("/app/task/create-task").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(getTask()))).andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(MockMvcResultHandlers.print());

	}
	
	
	@Test
	void testGetTaskById() throws Exception{
		
		mock.perform(MockMvcRequestBuilders.get("/app/task/retrieve-task?task_id=2").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(getTask()))).andExpect(MockMvcResultMatchers.status().isFound())
				.andDo(MockMvcResultHandlers.print());

	}
		
		

	@Test
	void testEditTask() throws Exception {
		mock.perform(MockMvcRequestBuilders.put("/app/task/edit-task/2").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(getTask()))).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	void testDeleteTask() throws Exception {
		mock.perform(MockMvcRequestBuilders.delete("/app/task/delete-task?user_id=2&task_id=2").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(getTask()))).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

}
