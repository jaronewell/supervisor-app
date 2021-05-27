package com.example.supervisorapp.service;

import com.example.supervisorapp.client.LightfeatherClient;
import com.example.supervisorapp.pojo.Supervisor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupervisorService {

  @Autowired private LightfeatherClient lightfeatherClient;

  public List<String> getAndFormatSupervisors() {
    return lightfeatherClient.getSupervisors().stream()
        .filter(supervisor -> !NumberUtils.isParsable(supervisor.getJurisdiction()))
        .sorted(
            Comparator.comparing(Supervisor::getJurisdiction)
                .thenComparing(Supervisor::getLastName)
                .thenComparing(Supervisor::getFirstName))
        .map(
            supervisor ->
                supervisor.getJurisdiction()
                    + " - "
                    + supervisor.getLastName()
                    + ", "
                    + supervisor.getFirstName())
        .collect(Collectors.toList());
  }
}
