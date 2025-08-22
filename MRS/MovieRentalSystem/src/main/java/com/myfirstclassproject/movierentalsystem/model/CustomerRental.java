/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myfirstclassproject.movierentalsystem.model;

import com.myfirstclassproject.movierentalsystem.enums.RentalPeriod;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author onalenna
 */
public class CustomerRental  {
    private Customer customer;
    private Movie movie;
    private RentalPeriod period;
    private LocalDate rentalDate = LocalDate.now();
    private LocalDate returnDate;
    private BigDecimal amountDue;
    
    public String toString(){
        return String.format("%s\nRental Period: %s\nRental Date: %s\nReturn Date: %s\nAmount Due: R%s\nCustomer Name: %s"
                ,this.movie,  this.period, this.rentalDate, this.returnDate, this.amountDue,  this.customer.getName());
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    
    public void setMovie(Movie movie){
        this.movie = movie;
    }
    
    public void setPeriod(RentalPeriod period){
        this.period = period;
    }
    
    public void setReturnDate(){
        switch (period) {
            case THREE_DAYS:
                this.returnDate  = this.rentalDate.plusDays(3);
                break;
            case WEEK:
                this.returnDate  = this.rentalDate.plusDays(7);
                break;
            default:
                this.returnDate  = this.rentalDate.plusDays(14);
                break;
        }
    }
    
    public void setAmountDue(){
        this.amountDue = this.period.getAmount();
    }
    
    public Customer getCustomer(){
        return this.customer;
    }
    
    public Movie getMovie(){
        return this.movie;
    }
    
     public RentalPeriod getPeriod(){
        return period;
    }
     
     public LocalDate getRentalDate(){
        return this.rentalDate;
    }
    
    public LocalDate getReturnDate(){
       return this.returnDate;
    }
    
    public BigDecimal getAmountDue(){
        return this.amountDue;
    }
}
