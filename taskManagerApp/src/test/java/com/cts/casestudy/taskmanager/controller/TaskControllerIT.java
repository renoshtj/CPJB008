package com.cts.casestudy.taskmanager.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.casestudy.taskmanager.entities.Task;
import com.cts.casestudy.taskmanager.service.TaskServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskControllerIT {

	private MockMvc mockMvc;
	
	@Mock
	private TaskServiceImpl taskService;
	
	@InjectMocks
	private TaskController taskController;
	
	@Before
	public void setUp() throws Exception{
		mockMvc= MockMvcBuilders.standaloneSetup(taskController).build();
	}
	
	@Test
	public void testGetAllTasks() throws Exception{
		Task task= new Task();
		task.setTitle("My sample test task");
		task.setTaskId(1);
		when(taskService.findTask(1)).thenReturn(task);
		
		mockMvc.perform(get("/casestudy/view/1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.taskId", Matchers.is(1)))
		.andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("My sample test task")));
		verify(taskService).findTask(1);
	}

}
