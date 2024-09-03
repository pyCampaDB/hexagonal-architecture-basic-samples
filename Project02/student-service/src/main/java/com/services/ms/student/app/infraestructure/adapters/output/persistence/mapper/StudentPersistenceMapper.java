package com.services.ms.student.app.infraestructure.adapters.output.persistence.mapper;

import com.services.ms.student.app.domain.model.Student;
import com.services.ms.student.app.infraestructure.adapters.output.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {
    //only necessary when the fields to be mapped are different
    //@Mapping(target = "age", source = "age")
    StudentEntity toStudentEntity(Student student);
    Student toStudent(StudentEntity studentEntity);

    List<Student> toStudentList(List<StudentEntity> studentEntityList);
}
