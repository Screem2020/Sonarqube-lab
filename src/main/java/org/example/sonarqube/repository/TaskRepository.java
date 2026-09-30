package org.example.sonarqube.repository;

import org.example.sonarqube.model.TaskDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository {
    List<TaskDto> findAll();
    @Query("""
            SELECT t FROM TaskEntity t
            WHERE t.id = :id
            """)
    Optional<TaskDto> findById(Long id);
    TaskDto save(TaskDto taskDto);
}
