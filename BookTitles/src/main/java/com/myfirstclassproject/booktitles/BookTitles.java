/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myfirstclassproject.booktitles;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Studio20-26
 */
public class BookTitles {

    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>(List.of("Mockingbird", "The Crucible", "Animal Farm"));
         for(String title: books){
             System.out.println(title);
         }
    }
}
