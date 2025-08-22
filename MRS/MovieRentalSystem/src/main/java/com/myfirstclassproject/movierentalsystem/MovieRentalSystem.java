/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myfirstclassproject.movierentalsystem;

import com.myfirstclassproject.movierentalsystem.model.MovieInventory;
import java.util.Scanner;

/**
 *
 * @author Studio20-26
 */
public class MovieRentalSystem {

    public static void main(String[] args) {
        System.out.println("MOVIE RENTAL SYSTEM");
        System.out.println("====================");
        
        Scanner scanner = new Scanner(System.in);
        MovieInventory runner = new MovieInventory();
        boolean isRunning = true;
        
        while(isRunning){
            displayMenu();
            System.out.print("Option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    isRunning = false;
                    System.out.println(">>>>Exited<<<<");
                    break;
                case 1:
                    runner.rentMovie();
                    break;
                case 2:
                    runner.returnMovie();
                    break;
                case 3:
                    System.out.println();
                    runner.displayAvailableMovies();
                    break;
                case 4:
                    System.out.println();
                    runner.displayRentedMovies();
                    break;
                case 5:
                    runner.displayCustomerRentals();
                    break;
                default:
                    System.out.println("Invalid Selection! Try again!");
                    break;
            }
            System.out.println();
        }
    }
    
    public static void displayMenu(){
        System.out.println("1: Rent a Movie\n2: Return a Movie\n3: View Available Movies\n4: View Rented Movies\n5: View Customer Rentals\n0: Exit");
    }
}
