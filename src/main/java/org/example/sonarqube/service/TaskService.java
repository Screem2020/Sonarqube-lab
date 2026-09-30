package org.example.sonarqube.service;

import org.example.sonarqube.model.TaskDto;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    TaskDto work(TaskDto taskDto);
    TaskDto findById(long id);
}
