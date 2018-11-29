/**
 * 
 */
package com.cts.casestudy.taskmanager.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.cts.casestudy.taskmanager.dao.TaskDAOImpl;
import com.cts.casestudy.taskmanager.entities.Task;
import com.cts.casestudy.taskmanager.repository.TaskRepositiryTestStub;

/**
 * @author Renosh
 *
 */


public class TaskServiceTest {

	private TaskServiceImpl taskService;

	private TaskDAOImpl taskDAO;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		taskService = new TaskServiceImpl();
		taskDAO= new TaskDAOImpl();
		taskService.setTaskDAO(taskDAO);
		taskDAO.setTaskRepository(new TaskRepositiryTestStub());
		
	}

	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.TaskService#createTask(com.cts.casestudy.taskmanager.entities.Task)}.
	 */
	@Test
	public void testCreateTask() {
		Task task= new Task();
		task.setTitle("My sample test task");
		Task savedTask=taskService.createTask(task);
		assertEquals(savedTask.getTaskId(),1);
	}

	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.TaskService#findAll()}.
	 */
	@Test
	@Ignore
	public void testFindAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.TaskService#findTask(java.lang.Integer)}.
	 */
	@Test
	@Ignore
	public void testFindTask() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.TaskService#delete(java.lang.Integer)}.
	 */
	@Test
	@Ignore
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.TaskService#updateTask(com.cts.casestudy.taskmanager.entities.Task)}.
	 */
	@Test
	@Ignore
	public void testUpdateTask() {
		fail("Not yet implemented");
	}

}
