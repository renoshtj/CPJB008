package com.cts.casestudy.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.casestudy.taskmanager.dao.ITaskDAO;
import com.cts.casestudy.taskmanager.entities.Task;
import com.cts.casestudy.taskmanager.utils.TaskNotFoundException;

@Transactional
@Service
public class TaskServiceImpl implements ITaskService{
	

	
	private ITaskDAO taskDAO;
	
	@Autowired
	public void setTaskDAO(ITaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	/* (non-Javadoc)
	 * @see com.cts.casestudy.taskmanager.service.TaskService#createTask(com.cts.casestudy.taskmanager.entities.Task)
	 */
	public Task createTask(Task task) {
		return taskDAO.save(task);
	}

	/*
	 * To search
	 */
	/* (non-Javadoc)
	 * @see com.cts.casestudy.taskmanager.service.TaskService#findAll()
	 */
	public List<Task> findAll() {
		return taskDAO.findAll();
	}

	/**
	 * @param taskId
	 * @return
	 * @throws TaskNotFoundException
	 */
	public Task findTask(Integer taskId) throws TaskNotFoundException {
		Optional<Task> optional = taskDAO.findTask(taskId);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new TaskNotFoundException("Task ID does not exist, please provide a valid ID");
	}

	/**
	 * Delete a task from database
	 * 
	 * @param taskId
	 */
	public void delete(Integer taskId) throws TaskNotFoundException {
		Optional<Task> optional = taskDAO.findTask(taskId);
		if (optional.isPresent()) {
			taskDAO.delete(optional.get());
		}
		throw new TaskNotFoundException("Task ID does not exist, please provide a valid ID");
	}

	/**
	 * Update an employee if exist
	 * @param taskDetails
	 * @return
	 * @throws TaskNotFoundException
	 */
	public Task updateTask(Task taskDetails) throws TaskNotFoundException {
		Optional<Task> optional = taskDAO.findTask(new Integer(taskDetails.getTaskId()));
		if (optional.isPresent()) {
			Task task = optional.get();
			task.setEndDate(taskDetails.getEndDate());
			task.setPriority(taskDetails.getPriority());
			task.setParentTaskId(taskDetails.getParentTaskId());
			Task updatedTask = createTask(task);
			return updatedTask;
		}
		throw new TaskNotFoundException("Task cannot be updated, please input a valid task");
	}
}
