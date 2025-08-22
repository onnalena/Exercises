/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myfirstclassproject.movierentalsystem.model;

/**
 *
 * @author Studio20-26
 */
public class Customer {
    private String IDNumber;
    private String name;
    private int age;
   
    public Customer(){}
    
    public Customer(String IDNumber, String name, int age){
        this.IDNumber = IDNumber;
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString(){
        return String.format("IDNumber: %s\nName: %s\nAge: %s", 
                this.IDNumber, this.name, this.age);
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
    
    public int getAge(){
        return age;
    }
    
    public String getIDNumber(){
        return this.IDNumber;
    }
    
    public String getName(){
        return this.name;
    }
}
