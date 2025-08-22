/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.myfirstclassproject.movierentalsystem.enums;

import java.math.BigDecimal;

/**
 *
 * @author Studio20-26
 */
public enum RentalPeriod {
    THREE_DAYS(new BigDecimal(20.0).setScale(2)),
    WEEK(new BigDecimal(50.0).setScale(2)),
    FORTNIGHT(new BigDecimal(100.0).setScale(2));
    
    private BigDecimal amount;
    
    RentalPeriod(BigDecimal amount) {
        this.amount = amount;
    }
    
    public BigDecimal getAmount() {
       return this.amount;
    }
}
