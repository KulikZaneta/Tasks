package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {
    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void testGetAllTasks() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task = new Task(1L, "test title", "test content");
        taskList.add(task);
        when(taskRepository.findAll()).thenReturn(taskList);
        //When
        List<Task> fetchedTaskList = dbService.getAllTasks();
        //Then
        assertEquals(1, fetchedTaskList.size());
    }

    @Test
    public void testGetTaskById() {
        //Given
        Long id = 1L;
        Task task = new Task(1L, "test title 1", "test content 1");
        when(taskRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(task));
        //When
        Optional<Task> task1 = dbService.getTask(id);
        //Then
        assertNotEquals(null, task1);
    }

    @Test
    public void testSaveTask() {
        //Given
        Long id = 1L;
        Task task = new Task(1L, "testA", "testB");
        //When
        when(taskRepository.save(task)).thenReturn(task);
        Task savedTask = dbService.saveTask(task);
        //Then
        assertEquals("testA", savedTask.getTitle());
    }
}
