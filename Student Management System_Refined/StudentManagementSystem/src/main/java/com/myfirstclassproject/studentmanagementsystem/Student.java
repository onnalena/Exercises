/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myfirstclassproject.studentmanagementsystem;

import com.myfirstclassproject.studentmanagementsystem.exceptions.NameException;
import com.myfirstclassproject.studentmanagementsystem.exceptions.AgeException;
import com.myfirstclassproject.studentmanagementsystem.exceptions.IDNumberException;
import java.util.ArrayList;
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

    Student() {
    }

    Student(String IDNumber, String name, int age, ArrayList<Subject> grades) {
        this.IDNumber = IDNumber;
        this.name = name;
        this.age = age;
        this.grades = grades;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrades(ArrayList<Subject> grades) {
        this.grades = grades;
    }

    public String getIDNumber() {
        return this.IDNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getge() {
        return this.age;
    }

    public ArrayList<Subject> getGrades() {
        return this.grades;
    }

    //Overriden method - displays object of Student
    public String toString() {
        return String.format("IDNumber: %s\nName: %s\nAge: %s\nGrades: \n%s\n", this.IDNumber, this.name, this.age, this.grades);
    }
    
    public double calculateStudentAverage() {
        int sum = 0;
        for (Subject subject : this.grades) {
            sum += subject.getGrade();
        }
        return sum / this.grades.size();
    }
    
    //Gets user input and also does validation
    public Student prompt(boolean isEdit) {
        Scanner scanner = new Scanner(System.in);
        boolean isStudentValid = false;

        while (!isStudentValid) {
            try {
                isStudentValid = studentPrompt(scanner);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        displayGradePrompt(isEdit);
        return this;
    }

    public boolean studentPrompt(Scanner scanner) {
        System.out.print("Enter student ID Number: ");
        String IDNumber = scanner.nextLine();
        if (IDNumber.length() != 13 || IDNumber.matches("[a-zA-z]+")) {
            throw new IDNumberException(IDNumber);
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        if (!name.matches("[a-zA-z]+")) {
            throw new NameException(IDNumber);
        }

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (age < 18) {
            throw new AgeException(IDNumber);
        }
        this.IDNumber = IDNumber;
        this.name = name;
        this.age = age;
        return true;
    }

    public void displayGradePrompt(boolean isEdit) {
        if (!isEdit) {
            gradePrompt();
        } else {
            editGradePrompt();
        }
    }

    public void editGradePrompt() {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;

        System.out.println("Enter student subject and grade:");
        for (Subject subject : grades) {
            System.out.print(String.format("Enter subject %s: ", counter));
            subject.setName(scanner.nextLine());

            System.out.print(String.format("Enter the grade for %s: ", subject.getName()));
            subject.setGrade(scanner.nextInt());
            scanner.nextLine();
            counter++;
        }
    }

    //Gets grades from user
    private void gradePrompt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter student subject and grade:");
        int counter = 1;
        boolean addMore = true;
       do{
           Subject subject = new Subject();
           System.out.print(String.format("Enter subject %s: ", counter));
           subject.setName(scanner.nextLine());

           System.out.print(String.format("Enter the grade for %s: ", subject.getName()));
           subject.setGrade(scanner.nextInt());
           System.out.println("Do you want to add another subject (Y/N): ");
           String choice = scanner.next();
           if(choice.equalsIgnoreCase("N")){
               addMore = false;
           }
           scanner.nextLine();
           counter++;
           this.grades.add(subject);
       }while(addMore);
    }
}
