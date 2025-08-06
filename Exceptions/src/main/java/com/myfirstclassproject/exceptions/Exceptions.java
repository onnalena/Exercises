/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myfirstclassproject.exceptions;

/**
 *
 * @author Studio20-26
 */
public class Exceptions {

    public static void main(String[] args) {
        Book book1 = new Book("Dreams", "Aya");
        Book book2 = new Book("Unhinged", "William");
        Book book3 = new Book("The Kays and Gs", "Oyisa");
        Book book4 = new Book("The Sea Is Driving Me Crazy", "Covi");
        Library lib = new Library();
        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);
        
        Library.displayAllBooks();
        try{
            lib.removeBook(book4);
        } catch(BookNotFoundException e){
            System.out.println(e.getMessage());
        }
        Library.displayAllBooks();
    }
}
