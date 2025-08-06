/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myfirstclassproject.classdesign;

import java.util.ArrayList;

/**
 *
 * @author Studio20-26
 */
public class Library {
    private final static ArrayList<Book> books = new ArrayList<>();
    
    public void addBook(Book newBook){
        books.add(newBook); 
    }
    
    public void removeBook(Book existingBook){
        if(books.contains(existingBook)){
            books.remove(existingBook);
        } else {
            throw new RuntimeException("Book doesn't exist!");
        }
    }
    
    public static void displayAllBooks(){
        int count = 0;
        for(Book book: books){
            System.out.println(String.format("Book %s:\n======\n%s", ++count, book.toString()));
        }
    }
}
