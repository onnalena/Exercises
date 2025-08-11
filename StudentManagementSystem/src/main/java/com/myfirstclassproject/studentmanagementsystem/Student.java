/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myfirstclassproject.studentmanagementsystem;

import com.myfirstclassproject.studentmanagementsystem.exceptions.NameException;
import com.myfirstclassproject.studentmanagementsystem.exceptions.AgeException;
import com.myfirstclassproject.studentmanagementsystem.exceptions.IDNumberException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Studio20-26
 */
public class Student {
    private String IDNumber;
    private String name;
    private int age;
    private ArrayList<Subject> grades = new ArrayList<>();
    
    Student(){}
    
    Student(String IDNumber, String name, int age, ArrayList<Subject> grades){
        this.IDNumber = IDNumber;
        this.name = name;
        this.age = age;
        this.grades = grades;
    }
    
    public void setIDNumber(String IDNumber){
        this.IDNumber = IDNumber;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public void setGrades(ArrayList<Subject> grades){
        this.grades = grades;
    }
    
    public String getIDNumber(){
        return this.IDNumber;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getge(){
        return this.age;
    }
    
    public ArrayList<Subject> getGrades(){
        return this.grades;
    }
    
    //Overriden method - displays object of Student
    public String toString(){
        return String.format("IDNumber: %s\nName: %s\nAge: %s\nGrades: \n%s\n", this.IDNumber, this.name, this.age, this.grades);
    }
    
    //Gets user input and also does validation
    public Student userInput(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Enter student ID Number: ");
            this.IDNumber = scanner.nextLine();
            
            System.out.print("Enter student name: ");
            this.name = scanner.nextLine();
            
            System.out.print("Enter student age: ");
            this.age = scanner.nextInt();
            
            validateStudent();
            gradeInput();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return this;
    }
    
    public double calculateStudentAverage(){
        int sum = 0;
        for(Subject subject: this.grades){
            sum+=subject.getGrade();
        }
        return sum / this.grades.size();
    }
    //Gets grades from user
    private void gradeInput(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nEnter student subject and grade:");
        for(int i = 1; i < 2; i++){
            Subject subject = new Subject();
            System.out.print(String.format("Enter subject %s: ", i));
            subject.setName(scanner.nextLine());
            
            System.out.print(String.format("Enter the grade for %s: ", subject.getName()));
            subject.setGrade(scanner.nextInt());
            
            scanner.nextLine();
            this.grades.add(subject);
        }
    }
    //Validates the student details
    private void validateStudent(){
         if(this.age < 18){
             throw new AgeException(this.IDNumber);
         }
         
         if(!this.name.matches("[a-zA-z]+")){
             throw new NameException(this.IDNumber);
         }
         
         if(this.IDNumber.length() != 13 || this.IDNumber.matches("[a-zA-z]+")){
            throw new IDNumberException(this.IDNumber);
        }
    }
}
