package com.company;

import java.util.Scanner;

public class Main {

    public static void printArray (String[] array) {
        for (int i=0; i<array.length;i++ ) {
            System.out.println(array[i]);
        }
    }

    public static void printCharArray (char[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws Exception {

        //-------------------------------Only one line in text and only one space in between---------------

        /*call the getMovie() method on Movie (class.We can do this since the getMovie method is static method
         does not really depend on an object. this will save us from declaring a Movie object just to implement
         the method on it to get a random movie)
         this will return a String with the name of a movie (randomly selected). and then we store this in
         String variable, randomMovie
         */
        String randomMovie = Movie.getMovie();
        //convert randomMovie to a char array
        char[] target = randomMovie.toCharArray();
        //create a new char array with its length equal to the randomMovie, and sets all its char to '-'
        char[] guessArray = new char[target.length];
        for (int c1=0; c1<guessArray.length; c1++){
            guessArray[c1] = '_';
        }


        //print out some instructions
        print("\nGod has chosen a movie title with " + target.length + " letters (no spaces, or numbers).\nAt any " +
                "point, you can try and type in the full name of the movie title and win.\nHowever, guessing the title"
                + " will also count as one try, so play wisely!");
        print("Please choose the difficulty of the game." +
                "\n1 ---------> hard (3 tries)\n2 ---------> moderate (5 tries)" +
                "\n3 ---------> easy (10 tries)");

        //call method getDifficulty on the game object. this will return an integer based on the user's input
        int numberTry = Movie.getDifficulty();

        print("Let's begin.\nReminder: Movie tittle has " + target.length + " letters.");

        //print out the guess array
        printCharArray(guessArray);

        //create a loop with the number of tries variable to check the user input word
        for (int i=numberTry; i>0; i--) {
            System.out.println("\nYou have " + i + " guess(es) left.\nPlease enter a letter");
            //Create a Scanner object to read the user input
            Scanner input = new Scanner(System.in);
            String userWord = input.nextLine();
            //checks if the user has entered the full name and if it matches the movie name. if yes print message and
            //exit the loop
            if (userWord.equals(randomMovie)) {
                print("You win!");
                return;
            /*  if the word does not match the movie title, check if it contains more than one letter. if it doesnt
                then go to the second loop to check the characters against the movie title. if they entered more than
                one letter go back to the beginning of the loop without checking the letter (because by trying to
                guess the full word, they forfeit their chance to guess the letters
            */
            } else if (userWord.length() == 1) {
                char guess = userWord.charAt(0);
                /*
                this loop checks the user input against all the movie letters and changes the guessArray at that
                particular index from _ to the letter
                 */
                for (int j = 0; j < target.length; j++) {
                            if (guessArray[j] == '_') {
                        if (target[j] == guess) {
                            guessArray[j] = guess;
                        }
                    }
                }
            }
            //prints the updated guessArray before going back to the beginning of the loop
            printCharArray(guessArray);
        }

        print("\nRan out of guesses.\nYou shall not beat GOD!!!\nTry again later.\n" +
                "Movie title we were looking for was: " + randomMovie);


    }
}


