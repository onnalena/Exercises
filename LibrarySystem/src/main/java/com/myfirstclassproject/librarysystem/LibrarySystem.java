/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myfirstclassproject.librarysystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Studio20-26
 */

/*
Creation of a project:
Step 1: On NetBeans click on 'New Project'
Step 2: Choose category - Java with Maven
Step 3: Choose project type - Java Application
Step 4: Name your project (LibrarySystem) and choose the location to save the project
Step 5: Click 'Finish'
This will create a project with a class called 'LibrarySystem' with a main method 

*/
public class LibrarySystem {
    private boolean hasCapacity = true;
    private final int capacity = 10;
    private final ArrayList<String> books = new ArrayList<>(List.of("Mockingbird", "The Crucible", "Animal Farm"));
    
    public void addBook(String title){
        if(!isFull()){
            throw new RuntimeException("Library has no capacity!");
        } else if(this.books.contains(title)){
            throw new RuntimeException("Book already exists!");
        } else{
            this.books.add(title);
            System.out.println(title + " was added!");
        }
    }
   
    public void displayAllBooks(){
        System.out.println(this.books);
    }
    
    private boolean isFull(){
         if(this.books.size() == this.capacity){
             this.hasCapacity = false;
         }
         return this.hasCapacity;
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Library System!");
        LibrarySystem lib = new LibrarySystem();
        lib.displayAllBooks();
        lib.addBook("Midsummer Night's Dream");
        lib.displayAllBooks();
    }
}
