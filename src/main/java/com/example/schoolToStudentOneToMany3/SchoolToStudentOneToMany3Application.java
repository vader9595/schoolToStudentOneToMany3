package com.example.schoolToStudentOneToMany3;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;







@SpringBootApplication
public class SchoolToStudentOneToMany3Application {

	public static void main(String[] args) {
		SpringApplication.run(SchoolToStudentOneToMany3Application.class, args);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager em = emf.createEntityManager();

		School mySchool = new School();
		mySchool.setName("My School");

		List<Student> myStudents = new ArrayList<>();
		Student student1 = new Student();
		student1.setName("Alice");
		student1.setSchool(mySchool);
		myStudents.add(student1);

		Student student2 = new Student();
		student2.setName("Bob");
		student2.setSchool(mySchool);
		myStudents.add(student2);

		mySchool.setStudents(myStudents);

		em.getTransaction().begin();
		em.persist(mySchool);
		em.getTransaction().commit();

		List<School> schools = em.createQuery("SELECT s FROM School s", School.class).getResultList();
		for (School school : schools) {
			System.out.println("School: " + school.getName());

			for (Student student : school.getStudents()) {
				System.out.println("Student: " + student.getName());
			}
		}

		em.close();
		emf.close();
	}
}
