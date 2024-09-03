package com.services.ms.student.app.infraestructure.adapters.output.persistence.repository;

import com.services.ms.student.app.infraestructure.adapters.output.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
