/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myfirstclassproject.studentmanagementsystem;

import com.myfirstclassproject.studentmanagementsystem.exceptions.StudentDoesNotExistException;
import com.myfirstclassproject.studentmanagementsystem.exceptions.StudentAlreadyExistsException;
import java.util.ArrayList;

/**
 *
 * @author Studio20-26
 */
public class StudentManagement {
    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    
    //Adds a new student if student already exists an exception is thrown
    public void addStudent(Student newStudent){
        if(this.students.contains(newStudent)){
            throw new StudentAlreadyExistsException(newStudent.getIDNumber());
        }
        this.students.add(newStudent);
        System.out.println(String.format("Student with ID: %s was successfully added!", newStudent.getIDNumber()));
    }
    
    //Removes student, if student doesn't exist an exception is thrown with a message
    public void removeStudent(Student existingStudent){
        if(!this.students.contains(existingStudent)){
            throw new StudentDoesNotExistException(existingStudent.getIDNumber());
        }
        this.students.remove(existingStudent);
        System.out.println(String.format("Student with ID: %s was successfully removed!", existingStudent.getIDNumber()));
    }
    
    //Edits an existing student, if student doesn't exist an exception is thrown with a message
    public void editStudent(Student editStudent){
        if(!this.students.contains(editStudent)){
            throw new StudentDoesNotExistException(editStudent.getIDNumber());
        }
        System.out.println("\nEditing Student with ID - " + editStudent.getIDNumber());
        editStudent.userInput();
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
        for(Student student: this.students){
            System.out.println(String.format("Student with ID: %s  has an average of: %s", student.getIDNumber(), student.calculateStudentAverage()));
        }
    }
}
