package com.example.schoolToStudentOneToMany3;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


    @Entity
    public class School {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @OneToMany(mappedBy = "school")
        private List<Student> students;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Student> getStudents() {
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }

        // getters and setters
    }




