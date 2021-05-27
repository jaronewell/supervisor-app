package com.example.supervisorapp.client;

import com.example.supervisorapp.pojo.Supervisor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "lightfeather", url="https://609aae2c0f5a13001721bb02.mockapi.io/lightfeather")
public interface LightfeatherClient {

    @GetMapping("/managers")
    List<Supervisor> getSupervisors();
}
