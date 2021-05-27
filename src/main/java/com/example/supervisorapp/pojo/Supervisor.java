package com.example.supervisorapp.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Supervisor {

  private String id;
  private String phone;
  private String jurisdiction;
  private String identificationNumber;
  private String firstName;
  private String lastName;
}
