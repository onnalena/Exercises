/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myfirstclassproject.studentmanagementsystem.exceptions;

/**
 *
 * @author Studio20-26
 */
public class AgeException extends RuntimeException{
     //Default exception message
    private static final String DEFAULT_MSG = "Student with ID: %s is underage, must be 18 to enroll!";
    
    public AgeException(String message){
        super(String.format(DEFAULT_MSG, message));
    }
}
