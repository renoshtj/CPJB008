package com.cts.casestudy.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.casestudy.taskmanager.entities.Task;
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
