package com.services.ms.student.app.application.service;

import com.services.ms.student.app.application.ports.input.StudentServicePort;
import com.services.ms.student.app.application.ports.output.StudentPersistencePort;
import com.services.ms.student.app.domain.exception.StudentNotFoundException;
import com.services.ms.student.app.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {
    private final StudentPersistencePort studentPersistencePort;
    @Override
    public Student findById(Long id) {
        return studentPersistencePort.findById(id)
                .orElseThrow(
                        StudentNotFoundException::new
                );
    }

    @Override
    public List<Student> findAll() {
        return studentPersistencePort.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentPersistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return studentPersistencePort.findById(id)
                .map(
                        savedStudent -> {
                            savedStudent.setFirstname(student.getFirstname());
                            savedStudent.setLastname(student.getLastname());
                            savedStudent.setAge(student.getAge());
                            savedStudent.setAddress(student.getAddress());
                            return studentPersistencePort.save(savedStudent);
                        }
                ).orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (studentPersistencePort.findById(id).isEmpty())
            throw new StudentNotFoundException();
        studentPersistencePort.deleteById(id);

    }
}
