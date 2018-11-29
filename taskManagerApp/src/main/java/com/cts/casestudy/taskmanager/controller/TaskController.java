package com.cts.casestudy.taskmanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.casestudy.taskmanager.entities.Task;
import com.cts.casestudy.taskmanager.service.ITaskService;
import com.cts.casestudy.taskmanager.utils.TaskNotFoundException;

@RestController
@RequestMapping("/casestudy")
public class TaskController {

	@Autowired
	ITaskService service;


	/**
	 * @param task
	 * @return
	 */
	@PostMapping("/createtask")
	public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
		return ResponseEntity.ok().body(service.createTask(task));
	}


	/**
	 * find all tasks in DB
	 * @return taskList
	 */
	@GetMapping("/alltasks")
	public List<Task> getAllTasks() {
		return service.findAll();
	}

	/**
	 * @param taskId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/view/{id}")
	public ResponseEntity getTaskBy(@PathVariable(value = "id") int taskId) {
		try {
			return ResponseEntity.ok().body(service.findTask(taskId));
		} catch (TaskNotFoundException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}


	/**
	 * Update an employee if exists
	 * @param taskId
	 * @param taskDetails
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PutMapping("/edit/{id}")
	public ResponseEntity updateTask(@PathVariable(value = "id") Integer taskId, @Valid @RequestBody Task taskDetails) {
		try {
			return ResponseEntity.ok().body(service.updateTask(taskDetails));
		} catch (TaskNotFoundException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}


	/**
	 * Delete an employee if exists
	 * @param taskId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteTask(@PathVariable(value = "id") Integer taskId) {
		try {
			service.delete(taskId);
			return ResponseEntity.ok().body("Task deleted successfully");
		} catch (TaskNotFoundException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}
}
