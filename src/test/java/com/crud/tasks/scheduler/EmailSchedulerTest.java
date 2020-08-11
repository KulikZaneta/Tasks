package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTest {
    @InjectMocks
    private EmailScheduler emailScheduler;

    @Mock
    private SimpleEmailService simpleEmailService;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TaskRepository taskRepository;

    private static final String SUBJECT = "Tasks: Once a day email";

    @Test
    public void sendInformationEmailWithOneTaskTest() throws Exception {
        when(taskRepository.count()).thenReturn(1L);
        when(adminConfig.getAdminMail()).thenReturn("kodilla@gmail.com");
        Mail mail = new Mail(adminConfig.getAdminMail(), SUBJECT, "Currently in database you got: 1 task", null);
        //When
        emailScheduler.sendInformationEmail();
        //Then
        verify(simpleEmailService, times(1)).send(any());
    }

    @Test
    public void sendInformationEmailWithManyTaskTest() throws Exception {
        when(taskRepository.count()).thenReturn(10L);
        when(adminConfig.getAdminMail()).thenReturn("kodilla@gmail.com");
        Mail mail = new Mail(adminConfig.getAdminMail(), SUBJECT, "Currently in database you got: 10 tasks", null);
        //When
        emailScheduler.sendInformationEmail();
        //Then
        verify(simpleEmailService, times(1)).send(any());
    }
}
