package org.example.sonarqube.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class TasksEntity {

    @Entity
    @Table(name = "tasks")
    public class TaskEntity {

        @Id
        private Long id;

        private String title;

        private String status;
    }
}
