package com.cts.casestudy.taskmanager.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.casestudy.taskmanager.entities.Task;
import com.cts.casestudy.taskmanager.repository.TaskRepository;

@Repository
public class TaskDAOImpl implements TaskDAO {

	
	private TaskRepository taskRepository;
	
	@Autowired
	public void setTaskRepository(TaskRepository taskRepository) {
		this.taskRepository=taskRepository;
	}
	/*
	 * Save a Task to DB
	 */
	@Override
	public Task save(Task task) {
		return taskRepository.save(task);
	}
	/*
	 * To search
	 */
	@Override
	public List<Task> findAll(){
		return taskRepository.findAll();
	}
	
	/*
	 * A container object which may or may not contain a non-null value. 
	 * If a value is present, isPresent() will return true 
	 * and get() will return the value. 
	 */
	@Override
	public Optional<Task> findTask(Integer taskId){
		return taskRepository.findById(taskId);
	}
	
	/**
	 * Delete a task from database
	 * @param task
	 */
	@Override
	public void delete(Task task) {
		taskRepository.delete(task);
	}
	
	//update
	
	
}
