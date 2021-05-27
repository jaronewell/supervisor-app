package com.example.supervisorapp.controller;

import com.example.supervisorapp.pojo.Registration;
import com.example.supervisorapp.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class SupervisorController {

  @Autowired private SupervisorService supervisorService;

  @GetMapping("/supervisors")
  public List<String> getSupervisors() {
    return supervisorService.getAndFormatSupervisors();
  }

  @PostMapping("/submit")
  public void submitRegistration(@RequestBody Registration registration){
    System.out.println("Registration received for " + registration.toString());
  }
}
