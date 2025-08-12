/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myfirstclassproject.studentmanagementsystem;

/**
 *
 * @author Studio20-26
 */
public class Subject {
    private String name;
    private int grade;
    Subject(){}
    Subject(String name, int grade){
        this.name = name;
        this.grade = grade;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setGrade(int grade){
        this.grade = grade;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getGrade(){
        return this.grade;
    }
    
    public String toString(){
        return String.format("Subject: %s\nGrade: %s", this.name, this.grade);
    }
}
