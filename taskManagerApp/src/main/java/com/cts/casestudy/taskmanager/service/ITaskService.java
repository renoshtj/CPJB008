package com.cts.casestudy.taskmanager.service;

import java.util.List;

import com.cts.casestudy.taskmanager.entities.Task;
import com.cts.casestudy.taskmanager.utils.TaskNotFoundException;

public interface ITaskService {

	public Task createTask(Task task) ;

	public List<Task> findAll() ;

	public Task findTask(Integer taskId) throws TaskNotFoundException;

	public void delete(Integer taskId) throws TaskNotFoundException;

	public Task updateTask(Task taskDetails) throws TaskNotFoundException;
}
