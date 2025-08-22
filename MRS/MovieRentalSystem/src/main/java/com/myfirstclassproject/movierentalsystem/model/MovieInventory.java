/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myfirstclassproject.movierentalsystem.model;

import com.myfirstclassproject.movierentalsystem.enums.AgeRestriction;
import com.myfirstclassproject.movierentalsystem.enums.Genre;
import com.myfirstclassproject.movierentalsystem.enums.RentalPeriod;
import com.myfirstclassproject.movierentalsystem.enums.RentalStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Studio20-26
 */
public class MovieInventory {
    List<Movie> movies = new ArrayList<>(List.of(new Movie("The Pickup", 2025, Genre.COMEDY, AgeRestriction.ALL), 
            new Movie("The Nun 2", 2023, Genre.HORROR, AgeRestriction.R_RATED),
            new Movie("Highlights", 1998, Genre.COMEDY, AgeRestriction.ALL)));
    List<CustomerRental> customerRentals = new ArrayList<>();
    List<Customer> existingCustomers = new ArrayList<>(List.of(
            new Customer("1234", "John", 12),
            new Customer("4321", "James", 12),
            new Customer("3421", "Kgothatso", 22),
            new Customer("2134", "Onalenna", 28)));
    
    public void displayAvailableMovies(){
        List<Movie> availableMovies = getAvailableMovies();
        if(availableMovies.isEmpty()){
            System.out.println("No available movies to display!");
        }else{
            int counter = 0;
            for (Movie movie : availableMovies) {
                System.out.println(++counter + ": " + movie);
                System.out.println();
            }
        }
    }
    
    public void displayRentedMovies(){
        List<Movie> rentedMovies = getRentedMovies();
        if(rentedMovies.isEmpty()){
            System.out.println("No rented movies to display!");
        }else{
            int counter = 0;
            for (Movie movie : rentedMovies) {
                System.out.println(++counter + ": " + movie);
                System.out.println();
            }
        }
    }
    
    public List<Movie> getAvailableMovies(){
        List<Movie> availableMovies = new ArrayList<>();
        for(Movie movie: this.movies){
            if(movie.getStatus().equals(RentalStatus.AVAILABLE)){
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }
    
    public List<Movie> getRentedMovies(){
        List<Movie> rentedMovies = new ArrayList<>();
        for(Movie movie: this.movies){
            if(movie.getStatus().equals(RentalStatus.RENTED)){
                rentedMovies.add(movie);
            }
        }
        return rentedMovies;
    }
    
    public void rentMovie(){
        CustomerRental customerRental = getCustomerDetails();
        
        if(customerRental.getCustomer() != null){
             Movie movie = getMovieSelection(customerRental.getCustomer().getAge());

            customerRental.setMovie(movie);
            getCustomerRentalPeriod(customerRental);

            customerRental.setReturnDate();
            customerRental.setAmountDue();

            this.customerRentals.add(customerRental);
            System.out.println("Customer Rental:");
            System.out.println("=================");
            System.out.println(customerRental);
        }
    }
    
    private List<CustomerRental> displayCustomerRentedMovies(String IDNumber){
        List<CustomerRental> customerRentals = new ArrayList<>();
        int counter = 0;
        for(CustomerRental customer: this.customerRentals){
            if(customer.getCustomer().getIDNumber().equals(IDNumber)){
                System.out.println(++counter + ": " + customer.getMovie());
                customerRentals.add(customer);
            }
        }
       return customerRentals; 
    }
    
    public void displayCustomerRentals(){
        if(!this.customerRentals.isEmpty()){
            System.out.println("Customer Rentals:");
            System.out.println("=================");
            int counter = 0;
            for (CustomerRental customerRental : this.customerRentals) {
                System.out.println(++counter + ": " + customerRental);
                System.out.println();
            }
        } else{
            System.out.println("No customer rentals to display!");
        }
        
    }
    
    private CustomerRental getCustomerDetails(){
        Scanner sc = new Scanner(System.in);
        CustomerRental customerRental = new CustomerRental();
        Customer customer = new Customer();
        
        System.out.print("Enter your ID Number: ");
        String IDNumber = sc.nextLine();
       
        for(Customer existingCustomer: this.existingCustomers){
            if(existingCustomer.getIDNumber().equals(IDNumber)){
                customer = existingCustomer;
                break;
            }
        }
        
        if(customer.getIDNumber() == null){
            System.out.println(String.format("Customer with ID - %s - does not exist!", IDNumber));
            System.out.print("Do you want to add a new customer? (Y/N): ");
            String response = sc.next();
            sc.nextLine();
            customer.setIDNumber(IDNumber);
            customer = addNewCustomer(response, customer, sc, customerRental);
        }else{
            customerRental.setCustomer(customer);
        }
        return customerRental;
    }
    
    private Movie getMovieSelection(int age){
        Scanner sc = new Scanner(System.in);
        Movie selectedMovie = null;
        boolean isAvailable = false;
        
        System.out.println("\nChoose movie to rent:");
        while(!isAvailable){
            displayAvailableMovies();
            System.out.print("Option: ");
            int option = sc.nextInt();
            sc.nextLine();
            
             try{
                if(getAvailableMovies().get(option - 1).getAgeRestriction()
                        .equals(AgeRestriction.R_RATED)){
                    if(age < 18){
                        System.out.println("R-Rated movie! Must be 18 years old to rent this movie!");
                    }
                } else{
                    isAvailable = true;
                    selectedMovie = getAvailableMovies().get(option - 1);
                    this.movies.get(this.movies.indexOf(selectedMovie)).setStatus(RentalStatus.RENTED);
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println("Invalid Selection! Try Again");
            }
        }
        return selectedMovie;
    }
    
    private void getCustomerRentalPeriod(CustomerRental customer){
        Scanner sc = new Scanner(System.in);
        boolean isSelectionValid = false;
        System.out.println("How long do you want to rent the movie for:");
        do{
            displayPeriodOptions();
            System.out.print("Option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    isSelectionValid = true;
                    customer.setPeriod(RentalPeriod.THREE_DAYS);
                    break;
                case 2:
                    isSelectionValid = true;
                    customer.setPeriod(RentalPeriod.WEEK);
                    break;
                case 3:
                    isSelectionValid = true;
                    customer.setPeriod(RentalPeriod.FORTNIGHT);
                    break;
                default:
                    System.out.println("Invalid Selection! Try again!");
                    break;
            }
        } while(!isSelectionValid);
    }
    
    private void displayPeriodOptions(){
        int counter = 0;
        for(RentalPeriod period: RentalPeriod.values()){
            System.out.println(++counter + ": " + period);
        }
    }
    
    private Customer addNewCustomer(String response, Customer customer, Scanner sc, CustomerRental customerRental){
        if(response.equalsIgnoreCase("Y")){
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            sc.nextLine();
            
            customer.setName(name);
            customer.setAge(age);
            
            this.existingCustomers.add(customer);
            customerRental.setCustomer(customer);
            System.out.println("Customer was successfully added!");
        }
        return customer;
    }
    
    public void returnMovie(){
       Scanner sc = new Scanner(System.in);
        boolean isSelectionValid = false;
        
        System.out.print("Enter customer's ID number: ");
        String IDNumber = sc.nextLine();
        
        while(!isSelectionValid){
            List<CustomerRental> customerRentals = displayCustomerRentedMovies(IDNumber);
            
            if (customerRentals.size() == 0) {
                System.out.println(String.format("Customer with ID - %s - has no rentals!", IDNumber));
                break;
            }
            System.out.print("Option: ");
            int option = sc.nextInt();
            sc.nextLine();
            
            try{
                this.movies.get(this.movies.indexOf(customerRentals.get(option - 1).getMovie())).setStatus(RentalStatus.AVAILABLE);
                displayAvailableMovies();
                this.customerRentals.remove(customerRentals.get(option - 1));
                System.out.println("Customer returned movie.");
                
                isSelectionValid = true;
            } catch(IndexOutOfBoundsException e){
                System.out.println("Invalid Selection! Try Again");
            }
        }
    }    
}
