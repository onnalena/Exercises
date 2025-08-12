/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myfirstclassproject.studentmanagementsystem;

import com.myfirstclassproject.studentmanagementsystem.exceptions.StudentDoesNotExistException;
import com.myfirstclassproject.studentmanagementsystem.exceptions.StudentAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Studio20-26
 */
public class StudentManagement {
    public ArrayList<Subject> subjects = new ArrayList<>(List.of(new Subject("Maths", 60)));
    public ArrayList<Student> students = new ArrayList<>(
            List.of(new Student("4510300368088", "Test User", 60,subjects)));
    
    public Student getStudent(String IDNumber){
        Student existingStudent = null;
        for(Student student: this.students){
            if(student.getIDNumber().equals(IDNumber)){
                 existingStudent = student;
            }
        }
        return existingStudent;
    }
    
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    
    //Adds a new student if student already exists an exception is thrown
    public void addStudent(Student newStudent){
        Student existingStudent = getStudent(newStudent.getIDNumber());
        if(existingStudent != null){
            throw new StudentAlreadyExistsException(newStudent.getIDNumber());
        }else{
            this.students.add(newStudent);
            System.out.println(String.format("Student with ID: %s was successfully added!", newStudent.getIDNumber()));
        }
    }
    
    //Removes student, if student doesn't exist an exception is thrown with a message
    public void removeStudent(){
        System.out.print("Enter the ID number of the student you want to remove: ");
        
        Scanner scanner = new Scanner(System.in);
        String IDNumber = scanner.nextLine();
        Student existingStudent = getStudent(IDNumber);
        
        if(existingStudent == null){
            throw new StudentDoesNotExistException(IDNumber);
        }
        
        this.students.remove(existingStudent);
        System.out.println(String.format("Student with ID: %s was successfully removed!", existingStudent.getIDNumber()));
    }
    
    //Edits an existing student, if student doesn't exist an exception is thrown with a message
    public void editStudent(){
        System.out.print("Enter the ID number of the student you want to edit: ");
        
        Scanner scanner = new Scanner(System.in);
        String IDNumber = scanner.nextLine();
        Student existingStudent = getStudent(IDNumber);
        
        System.out.println("\nEditing Student with ID - " + existingStudent.getIDNumber());
        
        existingStudent.prompt(true);
        
        System.out.println(String.format("Student with ID: %s was successfully updated!", 
                existingStudent.getIDNumber()));
    }
    //Displays all students, if no students, a message is displayed
    public void displayAllStudents(){
        if(this.students.isEmpty()){
            System.out.println("There are no students to display!");
        } else{
            System.out.println(this.students);
        }
    }
    
    public void displayAverages(){
        if(this.students.isEmpty()){
           System.out.println("There are no student averages to display!"); 
        } else{
            for(Student student: this.students){
                System.out.println(String.format("Student with ID: %s  has an average of: %s", student.getIDNumber(), student.calculateStudentAverage()));
            }
        }
    }
}