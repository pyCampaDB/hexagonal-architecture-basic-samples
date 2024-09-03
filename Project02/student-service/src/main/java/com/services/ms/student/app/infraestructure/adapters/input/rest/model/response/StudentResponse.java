package com.services.ms.student.app.infraestructure.adapters.input.rest.model.response;

import lombok.*;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String address;
}
