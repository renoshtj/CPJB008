package com.cts.casestudy.taskmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cts.casestudy.taskmanager.dao.ITaskDAO;
import com.cts.casestudy.taskmanager.dao.TaskDAOImpl;
import com.cts.casestudy.taskmanager.repository.TaskRepositiryTestStub;
import com.cts.casestudy.taskmanager.repository.TaskRepository;
import com.cts.casestudy.taskmanager.service.ITaskService;
import com.cts.casestudy.taskmanager.service.TaskServiceImpl;

@Configuration
public class TaskManagerTestConfig {
	
	@Bean
	TaskRepository taskRepository() {
		return new TaskRepositiryTestStub();
	}

	@Bean
	ITaskService taskService() {
		return new TaskServiceImpl();
	}
	
	@Bean
	ITaskDAO taskDAO() {
		return new TaskDAOImpl();
	}
}
