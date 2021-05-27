package com.example.supervisorapp.pojo;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class Registration {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String email;
    private String phoneNumber;
    private Supervisor supervisor;
}
