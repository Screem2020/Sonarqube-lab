package org.example.sonarqube.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.sonarqube.model.TaskDto;
import org.example.sonarqube.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SaveTaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    
    @Override
    public TaskDto work(TaskDto taskDto) {
        TaskDto save = taskRepository.save(taskDto);
        String description = save.description();
        log.info(description);
        return save;
    }

    @Override
    public TaskDto findById(long id) {
        return taskRepository.findById(id).orElse(null);
    }
}
