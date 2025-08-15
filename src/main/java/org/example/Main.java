package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            var random = new Random();
            var scanner = new Scanner(System.in);

            var props = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            props.load(input);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        int guess;
            int attempts=0;
        int min= Integer.parseInt(props.getProperty("randomMin"));
        int max= Integer.parseInt(props.getProperty("randomMax"));
            int randomNumber = random.nextInt(min,max+1);

        System.out.println("NUMBER GUESSING GAME!!!");
        System.out.printf("Guess a number between %d-%d\n",min,max);

        do {
            System.out.print ("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if(guess < randomNumber) {
                    System.out.println("Your guess is too low.Try again!!");
                }
                else if(guess > randomNumber) {
                    System.out.println("Your guess is too HIGH.Try again!!");
                }else {
                    System.out.println("CORRECT!!! The number was " + randomNumber);
                    System.out.println("You took " + attempts + " attempts");
                }
        }while(guess !=randomNumber);
        scanner.close();

    }
}