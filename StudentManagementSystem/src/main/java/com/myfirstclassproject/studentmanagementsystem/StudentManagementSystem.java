/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myfirstclassproject.studentmanagementsystem;

import com.myfirstclassproject.studentmanagementsystem.exceptions.StudentAlreadyExistsException;
import com.myfirstclassproject.studentmanagementsystem.exceptions.StudentDoesNotExistException;
import java.util.Scanner;

/**
 *
 * @author Studio20-26
 */
public class StudentManagementSystem {

    public static void main(String[] args) {
        //Used to get user input from terminal
        Scanner scanner = new Scanner(System.in);
        //Creating our objects
        Student newStudent = new Student();
        Student testStudent = new Student(); //created for testing
        StudentManagement studentManager = new StudentManagement();
        
        System.out.println("Welcome to Student Management System");
        System.out.println("====================================");
        System.out.println("Enter your option: \n1: Add Student\n2: Edit Student\n3: Remove Student\n4: Display students\n5: Display Avearages");
        int responseNum = scanner.nextInt();
        switch(responseNum){
            case 1: 
                 //Ask for user input and does validation
                newStudent.userInput();
                 //Add student 
                try{
                    studentManager.addStudent(newStudent);
                   //studentManager.addStudent(newStudent);
                }catch(StudentAlreadyExistsException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                //Edit student
                try{
                    studentManager.editStudent(newStudent);
                } catch(StudentDoesNotExistException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                 //Remove student
                try{
                    studentManager.removeStudent(testStudent);
                } catch(StudentDoesNotExistException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                //Displays all students
                studentManager.displayAllStudents();
                break;
            case 5:
                studentManager.displayAverages();
            default:
                System.out.println("Invalid option entered!");
        }
        /*
        
        
       
        
       
        
       
        
        
        System.out.println(studentManager.getStudents());
        //System.out.println(stu);
        */
        
    }
}
