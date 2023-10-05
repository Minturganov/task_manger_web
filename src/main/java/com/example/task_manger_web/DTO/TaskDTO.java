package com.example.task_manger_web.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO {
    private String id;
    private String title;
    private String content;
    private LocalDate deadlineDate;
}
