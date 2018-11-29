/**
 * 
 */
package com.cts.casestudy.taskmanager.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.cts.casestudy.taskmanager.dao.TaskDAOImpl;
import com.cts.casestudy.taskmanager.entities.Task;
import com.cts.casestudy.taskmanager.repository.TaskRepositiryTestStub;

/**
 * @author Renosh
 *
 */


public class ITaskServiceTest {

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
	@Ignore
	public void testFindAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.ITaskService#findTask(java.lang.Integer)}.
	 */
	@Test
	@Ignore
	public void testFindTask() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.ITaskService#delete(java.lang.Integer)}.
	 */
	@Test
	@Ignore
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cts.casestudy.taskmanager.service.ITaskService#updateTask(com.cts.casestudy.taskmanager.entities.Task)}.
	 */
	@Test
	@Ignore
	public void testUpdateTask() {
		fail("Not yet implemented");
	}

}
