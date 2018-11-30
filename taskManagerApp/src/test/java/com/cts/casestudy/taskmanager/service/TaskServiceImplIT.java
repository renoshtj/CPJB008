package com.cts.casestudy.taskmanager.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.casestudy.taskmanager.config.TaskManagerTestConfig;
import com.cts.casestudy.taskmanager.entities.Task;
import com.cts.casestudy.taskmanager.utils.TaskNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TaskManagerTestConfig.class})
public class TaskServiceImplIT {

	private ITaskService taskService;
	
	@Autowired
	public void setTaskService(ITaskService taskService) {
		this.taskService=taskService;
	}
	
	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.ITaskService#createTask(com.cts.casestudy.taskmanager.entities.Task)}.
	 */
	@Test
	public void testCreateTask() {
		Task task= new Task();
		task.setTitle("My sample test task");
		Task savedTask=taskService.createTask(task);
		assertEquals(savedTask.getTaskId(),1);
	}

	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.ITaskService#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Task> taskList=taskService.findAll();
		assertEquals(taskList.size(),1);
	}

	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.ITaskService#findTask(java.lang.Integer)}.
	 * @throws TaskNotFoundException 
	 */
	@Test(expected=TaskNotFoundException.class)
	public void testFindTask() throws TaskNotFoundException {
		taskService.findTask(new Integer(1));
	}

	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.ITaskService#delete(java.lang.Integer)}.
	 */
	@Test(expected=TaskNotFoundException.class)
	public void testDelete() throws TaskNotFoundException {
		taskService.delete(1);
	}

	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.ITaskService#updateTask(com.cts.casestudy.taskmanager.entities.Task)}.
	 */
	@Test(expected=TaskNotFoundException.class)
	public void testUpdateTask() throws TaskNotFoundException {
		Task task = new Task();
		task.setTaskId(1);
		taskService.updateTask(task);
	}
}
