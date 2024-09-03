package com.services.ms.student.app.infraestructure.adapters.input.rest;

import com.services.ms.student.app.application.ports.input.StudentServicePort;
import com.services.ms.student.app.infraestructure.adapters.input.rest.mapper.StudentRestMapper;
import com.services.ms.student.app.infraestructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.services.ms.student.app.infraestructure.adapters.input.rest.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentRestController {
    private final StudentServicePort studentServicePort;
    private final StudentRestMapper studentRestMapper;

    @GetMapping("/v1/api")
    public List<StudentResponse> findAll(){
        return studentRestMapper.toStudentResponseList(studentServicePort.findAll());
    }
    @GetMapping("/v1/api/{id}")
    public StudentResponse findById(@PathVariable Long id){
        return studentRestMapper.toStudentResponse(studentServicePort.findById(id));
    }

    @PostMapping("/v1/api")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentResponse> save(@Valid @RequestBody StudentCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentRestMapper.toStudentResponse(
                        studentServicePort.save(
                                studentRestMapper.toStudent(request)
                        )
                ));
    }

    @PutMapping("/v1/api/{id}")
    public StudentResponse update(@PathVariable Long id, @RequestBody StudentCreateRequest request){
        return studentRestMapper.toStudentResponse(
                studentServicePort.update(id,studentRestMapper.toStudent(request))
        );
    }

    @DeleteMapping("/v1/api/{id}")
    public void delete(@PathVariable Long id){
        studentServicePort.deleteById(id);
    }
}
