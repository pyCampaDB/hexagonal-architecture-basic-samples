package com.services.ms.student.app.infraestructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {
    @NotBlank(message = "Firstname field cannot be empty or null")
    private String firstname;
    @NotBlank(message = "Lastname field cannot be empty or null")
    private String lastname;
    @NotNull(message = "Age field cannot be null")
    private Integer age;
    @NotBlank(message = "Address field cannot be empty or null")
    private String address;
}
