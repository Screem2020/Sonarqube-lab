package org.example.sonarqube.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
public record TaskDto(
        @Id
        Long id,
        String title,
        String description,
        Boolean completed){
}
