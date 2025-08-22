/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myfirstclassproject.movierentalsystem.model;

import com.myfirstclassproject.movierentalsystem.enums.AgeRestriction;
import com.myfirstclassproject.movierentalsystem.enums.Genre;
import com.myfirstclassproject.movierentalsystem.enums.RentalStatus;
import java.time.LocalDate;

/**
 *
 * @author Studio20-26
 */
public class Movie {
    private String title;
    private int year;
    private Genre genre;
    private AgeRestriction ageRestriction;
    private RentalStatus status = RentalStatus.AVAILABLE;
    
    public Movie(){
        this.title = "No Title";
        this.year = LocalDate.now().getYear();
        this.genre = Genre.ACTION;
        this.ageRestriction = AgeRestriction.ALL;
    }
    
    public Movie(String title, int year, Genre genre, AgeRestriction ageRestriction){
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.ageRestriction = ageRestriction;
    }
    
    public String toString(){
        return String.format("%s\nGenre: %s\nYear: %s\nAge Restriction: %s\nStatus: %s",
                this.title,
                this.genre,
                this.year,
                this.ageRestriction,
                this.status);
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public void setGenre(Genre genre){
        this.genre = genre;
    }
    
    public void setAgeRestriction(AgeRestriction ageRestriction){
        this.ageRestriction = ageRestriction;
    }
    
    public void setStatus(RentalStatus status){
        this.status = status;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public int getYear(){
        return this.year;
    }
    
    public Genre getGenre(){
        return this.genre;
    }
    
    public AgeRestriction getAgeRestriction(){
        return this.ageRestriction;
    }
    
    public RentalStatus getStatus(){
        return this.status;
    }
}
