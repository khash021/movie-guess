package com.company;

import java.io.File;
import java.util.Scanner;

public class Movie {

    public void Movie(){

    }

    /**
     This method generates a random movie from our movies list file (movies.txt)
     No input.
     It is declared static because it does not need an object instance.
     @return String: name of the movie
     Note: At this point it, only works with text documents that have one line!
     */
    public static String getMovie() throws Exception {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        String movie = scanner.nextLine();
        String movieArray[] = movie.split("\\s+");
        String randomMovie = movieArray[(int) (Math.random() * movieArray.length)];
        return randomMovie;
    }

    /**
     This method handles the difficulty. it has no input parameter.
     It is declared static because it does not need an object instance.
     It asks the user to choose the difficulty by selection a number between 1 and 3.
     @return an int which is the number of tries the user get based on their difficulty selection
               the default value (in case they choose something other their options is 5 tries (moderate difficulty)
     */
    public static int getDifficulty() {
        System.out.println("Enter a number between 1 and 3");
        Scanner scanner = new Scanner(System.in);
        String difficulty = scanner.nextLine();
        int difficultyInput = Integer.parseInt(difficulty);
        int numTry;
        switch (difficultyInput) {
            case 1:
                numTry = 3;
                break;
            case 2:
                numTry = 5;
                break;
            case 3:
                numTry = 10;
                break;
            default:
                numTry = 5;
                break;
        }
        return numTry;
    }

}