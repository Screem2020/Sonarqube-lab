package org.example.sonarqube.repository;

import org.example.sonarqube.model.TaskDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTaskRepository  implements TaskRepository{

    private final Map<Long, TaskDto> tasks =  new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    @Override
    public List<TaskDto> findAll() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public Optional<TaskDto> findById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    @Override
    public TaskDto save(TaskDto taskDto) {
        Long id = nextId.getAndIncrement();
        TaskDto saveTaskDto = new TaskDto(
                id,
                taskDto.title(),
                taskDto.description(),
                taskDto.completed()

        );
        tasks.put(id, saveTaskDto);
        return saveTaskDto;
    }
}
