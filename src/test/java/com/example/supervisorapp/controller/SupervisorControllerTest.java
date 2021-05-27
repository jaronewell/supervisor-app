package com.example.supervisorapp.controller;

import com.example.supervisorapp.service.SupervisorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class SupervisorControllerTest {

  @InjectMocks private SupervisorController supervisorController;

  @Mock private SupervisorService supervisorService;

  @Test
  void getSupervisorsCallsServiceAndReturnsListOfStrings() {

    List<String> expected =
        Arrays.asList(
            "a - Barton, Nancy",
            "a - Smith, Albert",
            "a - Smith, John",
            "c - Rogers, Bob",
            "w - Anderson, Frank");
    Mockito.when(supervisorService.getAndFormatSupervisors()).thenReturn(expected);

    List<String> actual = supervisorController.getSupervisors();

    Mockito.verify(supervisorService).getAndFormatSupervisors();
    assertThat(actual).isEqualTo(expected);
  }
}
