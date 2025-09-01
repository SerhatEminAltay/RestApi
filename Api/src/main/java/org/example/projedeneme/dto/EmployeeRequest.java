package org.example.projedeneme.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequest {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int birthYear;

}
