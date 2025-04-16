public package com.example.hibernate;

import java.util.List;

import com.example.hibernate.dao.StudentDAO;
import com.example.hibernate.entity.Student;
import com.example.hibernate.util.HibernateUtil;

public class MainApp {
    public static void main(String[] args) {
        // Create StudentDAO
        StudentDAO studentDAO = new StudentDAO();
        
        System.out.println("========== Hibernate CRUD Operations Demo ==========");
        
        // Create some students
        System.out.println("\n--- Creating students ---");
        Student student1 = new Student("John Doe", 20);
        Student student2 = new Student("Jane Smith", 22);
        Student student3 = new Student("Mike Johnson", 21);
        
        // Save students
        studentDAO.saveStudent(student1);
        studentDAO.saveStudent(student2);
        studentDAO.saveStudent(student3);
        
        // Get all students
        System.out.println("\n--- Listing all students ---");
        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        
        // Get student by ID
        System.out.println("\n--- Getting student by ID ---");
        Student retrievedStudent = studentDAO.getStudent(student1.getId());
        System.out.println("Retrieved student: " + retrievedStudent);
        
        // Update student
        System.out.println("\n--- Updating student ---");
        retrievedStudent.setName("John Updated");
        retrievedStudent.setAge(25);
        studentDAO.updateStudent(retrievedStudent);
        
        // Verify update
        Student updatedStudent = studentDAO.getStudent(retrievedStudent.getId());
        System.out.println("Updated student: " + updatedStudent);
        
        // Delete student
        System.out.println("\n--- Deleting student ---");
        studentDAO.deleteStudent(student3.getId());
        
        // Verify deletion by listing all students
        System.out.println("\n--- Final student list ---");
        students = studentDAO.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        
        // Close Hibernate
        HibernateUtil.shutdown();
    }
}

