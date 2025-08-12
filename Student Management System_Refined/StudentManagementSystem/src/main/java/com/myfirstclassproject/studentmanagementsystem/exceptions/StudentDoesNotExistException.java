/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myfirstclassproject.studentmanagementsystem.exceptions;

/**
 *
 * @author Studio20-26
 */
public class StudentDoesNotExistException extends RuntimeException{
    private static final String DEFAULT_MSG = "Student with ID: %s doesn't exist!";
    
    public StudentDoesNotExistException(String message){
        super(String.format(DEFAULT_MSG, message));
    }
}
