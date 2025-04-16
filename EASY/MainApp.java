package com.example.spring.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load the Spring context using Java-based configuration
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Retrieve the beans from the context
        Student student1 = context.getBean("student1", Student.class);
        Student student2 = context.getBean("student2", Student.class);
        
        // Display student information
        System.out.println("Student 1 Information:");
        student1.displayInfo();
        
        System.out.println("\nStudent 2 Information:");
        student2.displayInfo();
        
        // Close the context
        context.close();
    }
}
