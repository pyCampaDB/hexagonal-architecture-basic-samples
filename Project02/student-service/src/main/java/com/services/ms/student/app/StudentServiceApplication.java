package com.services.ms.student.app;

import com.services.ms.student.app.infraestructure.adapters.output.persistence.entity.StudentEntity;
import com.services.ms.student.app.infraestructure.adapters.output.persistence.repository.StudentRepository;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StudentServiceApplication implements CommandLineRunner {
	private final StudentRepository studentRepository;

	public StudentServiceApplication(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	//to have test data
	@Override
	public void run(String... args) throws Exception {
		List<StudentEntity> entities = Arrays.asList(
				new StudentEntity(null, "Zaraki", "Kenpachi", 37, "11th Squadron"),
				new StudentEntity(null, "Madara", "Uchiha", 60, "Konohagakure no sato"),
				new StudentEntity(null, "Toji", "Zen'in", 28, "Wizard School"),
				new StudentEntity(null, "Eren", "Jaegger", 19, "Siganshina")
		);
		studentRepository.saveAll(entities);
	}
}
