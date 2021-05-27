package com.example.supervisorapp.service;

import com.example.supervisorapp.client.LightfeatherClient;
import com.example.supervisorapp.pojo.Supervisor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class SupervisorServiceTest {

  @InjectMocks private SupervisorService supervisorService;

  @Mock private LightfeatherClient lightfeatherClient;

  @Test
  void getSupervisorsReturnsCorrectlyFormattedList() {
    List<Supervisor> supervisors = getSampleSupervisorList();
    Mockito.when(lightfeatherClient.getSupervisors()).thenReturn(supervisors);

    List<String> actual = supervisorService.getAndFormatSupervisors();
    List<String> expected =
        Arrays.asList(
            "a - Barton, Nancy",
            "a - Smith, Albert",
            "a - Smith, John",
            "c - Rogers, Bob",
            "w - Anderson, Frank");
    assertThat(actual).isEqualTo(expected);
  }

  private List<Supervisor> getSampleSupervisorList() {
    List<Supervisor> supervisors = new ArrayList<>();
    supervisors.add(
        Supervisor.builder()
            .firstName("Frank")
            .lastName("Anderson")
            .phone("123-456-7890")
            .id("1")
            .identificationNumber("1")
            .jurisdiction("w")
            .build());
    supervisors.add(
        Supervisor.builder()
            .firstName("John")
            .lastName("Smith")
            .phone("123-456-7890")
            .id("1")
            .identificationNumber("1")
            .jurisdiction("a")
            .build());
    supervisors.add(
        Supervisor.builder()
            .firstName("Albert")
            .lastName("Smith")
            .phone("123-456-7890")
            .id("1")
            .identificationNumber("1")
            .jurisdiction("a")
            .build());
    supervisors.add(
        Supervisor.builder()
            .firstName("Bob")
            .lastName("Rogers")
            .phone("123-456-7890")
            .id("1")
            .identificationNumber("1")
            .jurisdiction("c")
            .build());
    supervisors.add(
        Supervisor.builder()
            .firstName("Nancy")
            .lastName("Barton")
            .phone("123-456-7890")
            .id("1")
            .identificationNumber("1")
            .jurisdiction("a")
            .build());
    supervisors.add(
        Supervisor.builder()
            .firstName("Ted")
            .lastName("Johnson")
            .phone("123-456-7890")
            .id("1")
            .identificationNumber("1")
            .jurisdiction("2")
            .build());
    return supervisors;
  }
}
