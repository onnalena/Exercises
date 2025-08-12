/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myfirstclassproject.studentmanagementsystem;

import com.myfirstclassproject.studentmanagementsystem.exceptions.StudentAlreadyExistsException;
import com.myfirstclassproject.studentmanagementsystem.exceptions.StudentDoesNotExistException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Studio20-26
 */
public class StudentManagementSystem {
    
    public static void main(String[] args) {
        System.out.println("Welcome to Student Management System");
        System.out.println("====================================");
        
        //Used to get user input from terminal
        Scanner scanner = new Scanner(System.in);
        //Creating our objects
        Student newStudent = new Student();
        StudentManagement studentManager = new StudentManagement();
        
        displayMenu();
        
        try {
           int  responseNum = scanner.nextInt();
           
            while (responseNum != 0) {
                switch (responseNum) {
                    case 1:
                        System.out.println("Adding New Student ");
                        System.out.println("===================");
                        //Ask for user input and does validation
                        newStudent.prompt(false);
                        //Add student 
                        studentManager.addStudent(newStudent);
                        break;
                    case 2:
                        //Edit student
                        studentManager.editStudent();
                        break;
                    case 3:
                        System.out.println("Removing Existing Student");
                        System.out.println("=======================");
                        //Remove student
                        studentManager.removeStudent();
                        break;
                    case 4:
                        //Displays all students
                        studentManager.displayAllStudents();
                        break;
                    case 5:
                        studentManager.displayAverages();
                        break;
                    default:
                        System.out.println("Invalid option entered! Try again.");
                        displayMenu();
                        responseNum = scanner.nextInt();
                }
                System.out.println();
                displayMenu();
                responseNum = scanner.nextInt();
            }
        } catch (StudentAlreadyExistsException | StudentDoesNotExistException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid entry! I have no idea how to handle this so please re-run.");
        }
    }
    
    public static void displayMenu(){
        System.out.println("""
                           Enter your option: 
                           1: Add Student
                           2: Edit Student
                           3: Remove Student
                           4: Display students
                           5: Display Avearages
                           0: Exit""");
    }
}
