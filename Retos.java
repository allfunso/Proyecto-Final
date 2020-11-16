/**
 * Esta versión de la clase Retos no está terminada
 * Se planea agregar otros 4 retos
 * El reto de buscar pelotas tiene algunos errores en esta versión
 * Se planea mover las herramientas de cada reto a la clase Robot
 */

import java.util.Scanner;

public class Retos {
    Scanner scan = new Scanner(System.in);

    int points = 0;

    void shootingChallenge() {
        int force;
        System.out.println("Enter your force");

        for(int numOfBalls=4; numOfBalls>0; numOfBalls--) {
            force = scan.nextInt();
            if (force>=60) {
                System.out.println("Too high! you failed");
            }
            if (force>50 && force<60) {
                System.out.println("you hit it! just above the center");
                points += 5;
            }
            if (force==50) {
                System.out.println("You nailed it!");
                points += 10;
            }
            if (force>=40 && force<50) {
                System.out.println("You hit it! just below the center");
                points += 5;
            }
            if (force < 40) {
               System.out.println("Very low! you failed");
            }
            if (numOfBalls > 0) {
                System.out.println("Try again");
            }
        }
        System.out.println("You ran out of balls");
        System.out.println("You scored " + points + " points");
    }

    void defendingChallenge() {

        int distance = (int) (Math.random()*10 + 5);

        System.out.println("There is a robot " + distance + " meters away");
        for (int i=0; i<=3; i++) {
            System.out.println("How far would you like to move?");
            distance -= scan.nextInt();
            if (distance > 1) {
                System.out.println("You are still too far away");
                if (i==3) {
                    System.out.println("You ran out of attempts");
                }
            } else if (distance < 0) {
                System.out.println("You went too far. Type a negative integer to go backwards");
                if (i==3) {
                    System.out.println("You ran out of attempts");
                }
            } else {
                System.out.println("You have blocked the robot succesfully");
                points += (10-2*i);
                break;
            }
            System.out.println("You have received " + points + " points");
        }
    }

    void clawChallenge() {
        System.out.println("There is a metal pole hanging over the robot");
        System.out.println("The robot must extend its arm to grab it");
        System.out.println("How far would you like to extend its arm?");
        double extension = scan.nextDouble();
        if (extension>=1 && extension<=2) {
            System.out.println("You did it!");
            points += 5;
            System.out.println("Now enter a negative number to pull it back");
            extension += scan.nextDouble();
            if (extension > 0.5) {
                System.out.println("You had to pull harder");
            } else if (extension < -0.5) {
                System.out.println("You pulled too hard! Now it's broken");
            } else {
                System.out.println("Well done");
                points += 5;
            }
        } else {
            System.out.println("The pole was 1.5 meters away");
            System.out.println("Maybe next time");
        }
        System.out.println("You scored " + points + " points");
    }
    
    void searchingChallenge() {
        Robot llamar = new Robot();
        int num;
        int numOfBalls = 0;
        Boolean grab;
        System.out.println("Search the 5 Balls move it and the system will tell you if you need to go further or closer ");

        int random=(int)(Math.random()*10);
        num=scan.nextInt();

        do{
            llamar.search(num, random);
            while(num!=random);
            System.out.println("You find the ball, to grab it enter 'true' ");
            grab = scan.nextBoolean();
            if (grab) {
                numOfBalls+=1;
                System.out.println("Now return to your base");
                int r=(int)(Math.random()*12);
                System.out.println("move it and the system will tell you if you need to go further or closer");
                num=scan.nextInt();
                llamar.search(num, r);
            }
            else {
                System.out.println("You must grab the ball");
            }
            System.out.println("You find the base, now drop the ball ");
            if(!grab){
                System.out.println("You must leave the ball");
            }
            else{
                System.out.println("Now search for more balls");
            }
        }
        while(numOfBalls!=5);
        System.out.println("You did it");
    }
}
