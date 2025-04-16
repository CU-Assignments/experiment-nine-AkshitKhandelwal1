package com.example.spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    @Bean
    public Course javaCourse() {
        Course course = new Course();
        course.setCourseName("Java Programming");
        course.setDuration(6);
        return course;
    }
    
    @Bean
    public Course pythonCourse() {
        return new Course("Python Programming", 4);
    }
    
    @Bean
    public Student student1() {
        // Constructor injection
        return new Student("John Doe", javaCourse());
    }
    
    @Bean
    public Student student2() {
        // Setter injection
        Student student = new Student();
        student.setName("Jane Smith");
        student.setCourse(pythonCourse());
        return student;
    }
}
