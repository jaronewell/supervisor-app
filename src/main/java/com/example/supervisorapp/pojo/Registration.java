package com.example.supervisorapp.pojo;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class Registration {

  @NotEmpty(message = "First Name must be provided")
  private String firstName;

  @NotEmpty(message = "Last Name must be provided")
  private String lastName;

  private String email;
  private String phoneNumber;

  @NotNull(message = "Supervisor must be provided")
  private Supervisor supervisor;
}
