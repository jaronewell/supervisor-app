package com.example.supervisorapp.controller;

import com.example.supervisorapp.service.SupervisorService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
public class SupervisorControllerTest {

  @Autowired private SupervisorController supervisorController;

  @MockBean private SupervisorService supervisorService;

  @Autowired private MockMvc mockMvc;

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

  @Test
  void submitRegistrationReturnsOkWhenSuccessful() throws Exception {

    String requestString =
        "{\n"
            + "    \"firstName\": \"Tom\",\n"
            + "    \"lastName\": \"Gregory\",\n"
            + "    \"email\": \"tomgregory@gmail.com\",\n"
            + "    \"phoneNumber\": \"123-456-7890\",\n"
            + "    \"supervisor\": \n"
            + "    {\n"
            + "        \"id\": \"5\",\n"
            + "        \"phone\": \"(964) 512-1445\",\n"
            + "        \"jurisdiction\": \"8\",\n"
            + "        \"identificationNumber\": \"93fd04ee-655a-47c2-832b-d83056d29e1e\",\n"
            + "        \"firstName\": \"Kieran\",\n"
            + "        \"lastName\": \"Torphy\"\n"
            + "    }\n"
            + "}";

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/submit")
                .content(requestString)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void submitRegistrationReturnsBadRequestWhenValidationFails() throws Exception {

    String requestString =
        "{\n"
            + "    \"firstName\": \"Tom\",\n"
            + "    \"email\": \"tomgregory@gmail.com\",\n"
            + "    \"phoneNumber\": \"123-456-7890\",\n"
            + "    \"supervisor\": \n"
            + "    {\n"
            + "        \"id\": \"5\",\n"
            + "        \"phone\": \"(964) 512-1445\",\n"
            + "        \"jurisdiction\": \"8\",\n"
            + "        \"identificationNumber\": \"93fd04ee-655a-47c2-832b-d83056d29e1e\",\n"
            + "        \"firstName\": \"Kieran\",\n"
            + "        \"lastName\": \"Torphy\"\n"
            + "    }\n"
            + "}";

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/submit")
                .content(requestString)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.lastName", Is.is("Last Name must be provided")));
  }
}
