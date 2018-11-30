package com.cts.casestudy.taskmanager.dao;

import java.util.List;
import java.util.Optional;

import com.cts.casestudy.taskmanager.entities.Task;

public interface ITaskDAO {

	public Task save(Task task);
	
	public List<Task> findAll();
	
	public Optional<Task> findTask(Integer taskId);
	
	public void delete(Task task);
}
