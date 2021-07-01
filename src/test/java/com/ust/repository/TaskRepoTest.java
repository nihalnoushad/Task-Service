package com.ust.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.model.Task;


@SpringBootTest
class TaskRepoTest {

    @Autowired
    private TaskRepo taskRepo;
    private Task task;

 

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setId(1);
        task.setRole_id(1);
        task.setTask_name("Imneet");
        task.setTask_Descreption("Sample content");
        task.setTask_start_date("2021-06-28");
        task.setTask_end_date("2021-06-30");
    }

 


    @AfterEach
    void tearDown() {
        taskRepo.deleteAll();
        task = null;
    }

 

//    @Test
//    public void givenTaskToCreateThenShouldReturnCreatedTask() {
//        taskRepo.save(task);
//        Task createdTask = taskRepo.findById(task.getId()).get();
//        assertEquals(1, createdTask.getId());
//    }

 


 

    @Test
    public void givenTaskIdThenShouldReturnRespectiveTask() {
        Task task = new Task(1, 1,"njnjn","sbbfff", "2020-12-20", "2021-02-15");
        Task task1 = taskRepo.save(task);
        Optional<Task> optional = taskRepo.findById(task1.getId());
        assertEquals(task1.getId(), optional.get().getId());
        assertEquals(task1.getRole_id(), optional.get().getRole_id());
        assertEquals(task1.getTask_name(), optional.get().getTask_name());
        assertEquals(task1.getTask_Descreption(), optional.get().getTask_Descreption());
        assertEquals(task1.getTask_start_date(), optional.get().getTask_start_date());
        assertEquals(task1.getTask_end_date(), optional.get().getTask_end_date());
        
    }

 

//    @Test
//    public void givenTaskIdToDeleteThenShouldReturnDeletedTask() {
//    	Task task = new Task(1, 1,"njnjn","sbbfff", "2020-12-20", "2021-02-15");
//        taskRepo.save(task);
//        taskRepo.deleteById(task.getId());
//        Optional optional = taskRepo.findById(task.getId());
//        assertEquals(Optional.empty(), optional);
//    }

 

}
