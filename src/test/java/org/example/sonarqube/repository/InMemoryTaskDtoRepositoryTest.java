package org.example.sonarqube.repository;

import org.example.sonarqube.model.TaskDto;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskDtoRepositoryTest {

    InMemoryTaskRepository inMemoryTaskRepository = new InMemoryTaskRepository();
    TaskDto taskDto = new TaskDto(null, "task1", "task2", true);

    @Test
    void saveNewTaskAssignsId() {
        TaskDto save = inMemoryTaskRepository.save(taskDto);

        Optional<TaskDto> findIdTask = inMemoryTaskRepository.findById(save.id());

        assertNotNull(save.id());
        assertTrue(findIdTask.isPresent());

        assertEquals(save, findIdTask.get());
    }


    @Test
    void saveNewTaskAssignsIdEmpty() {
        Optional<TaskDto> result = inMemoryTaskRepository.findById(999L);

        assertTrue(result.isEmpty());
    }

    @Test
    void findAllTasks() {
        inMemoryTaskRepository.save(taskDto);
        inMemoryTaskRepository.save(taskDto);

        int actual = inMemoryTaskRepository.findAll().size();

        assertEquals(2, actual);
    }

    @Test
    void saveTaskAssignsUniqueIds() {
        TaskDto saveOne = inMemoryTaskRepository.save(taskDto);
        TaskDto saveTwo = inMemoryTaskRepository.save(taskDto);

        assertNotEquals(saveOne.id(), saveTwo.id());
    }

}