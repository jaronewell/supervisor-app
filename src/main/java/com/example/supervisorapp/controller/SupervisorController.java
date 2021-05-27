package com.example.supervisorapp.controller;

import com.example.supervisorapp.pojo.Registration;
import com.example.supervisorapp.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class SupervisorController {

  @Autowired private SupervisorService supervisorService;

  @GetMapping("/supervisors")
  public List<String> getSupervisors() {
    return supervisorService.getAndFormatSupervisors();
  }

  @PostMapping("/submit")
  public ResponseEntity<String> submitRegistration(@Valid @RequestBody Registration registration){
    System.out.println("Registration received for " + registration.toString());
    return ResponseEntity.ok("Registration submission successful");
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(
          MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }
}
