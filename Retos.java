/**
 * Esta versión de la clase Retos no está terminada
 * Se planea agregar otros 4 retos
 * El reto de buscar pelotas tiene algunos errores en esta versión
 */

import java.util.Random;
import java.util.Scanner;

public class Retos {
    Scanner scan = new Scanner(System.in);
    Random randomGenerator = new Random();
    int points = 0;
    String tool;

    void shootingChallenge(Robot player) {
        int force;
        System.out.println("There's a target that you have to shoot");
        System.out.println("Choose between one of your tools to complete the challenge:");

        for(int numOfBalls=4; numOfBalls>0; numOfBalls--) {
            System.out.println("SHOOT, MOVE, EXTEND, SEARCH");
            tool = scan.next();
            player.chooseTool(tool);

            if (tool.equalsIgnoreCase("shoot")) {
                force = player.shootingForce;
                if (force>=60) {
                    System.out.println("Too high! you failed");
                }
                else if (force>50) {
                    System.out.println("you hit it! just above the center");
                    points += 5;
                }
                else if (force==50) {
                    System.out.println("You nailed it!");
                    points += 10;
                }
                else if (force>=40) {
                    System.out.println("You hit it! just below the center");
                    points += 5;
                }
                else {
                   System.out.println("Very low! you failed");
                }
            } else {
                System.out.println("That's not the tool you should've used");
            }
            if (numOfBalls > 1) {
                System.out.println("Try again");
            }
        }
        System.out.println("You ran out of balls");
        System.out.println("You've scored " + points + " points so far");
    }

    void defendingChallenge(Robot player) {
        player.position = 0;

        int distance = randomGenerator.nextInt(10) + 5;
        System.out.println("There is a robot a few meters away");
        System.out.println("Choose between one of your tools to block it");

        for (int i=0; i<=3; i++) {
            System.out.println("SHOOT, MOVE, EXTEND, SEARCH");
            tool = scan.next();
            player.chooseTool(tool);

            if (tool.equalsIgnoreCase("move")) {
                if (distance > player.position) {
                    System.out.println("You are still too far away. Move forward");
                } else if (distance < player.position) {
                    System.out.println("You went too far. Type a negative integer to move backwards");
                } else {
                    System.out.println("You have blocked the robot succesfully");
                    points += (10-2*i);
                    break;
                }
            } else {
                System.out.println("That's not the tool you should've used");
            }
            if (i==3) System.out.println("You ran out of attempts");
        }
        System.out.println("You have scored " + points + " points so far");
    }

    void clawChallenge(Robot player) {
        player.extension = 0;

        System.out.println("There is a metal pole hanging over the robot");
        System.out.println("The robot must extend its arm to grab it");
        System.out.println("Choose a tool to do so");

        do {
        System.out.println("SHOOT, MOVE, EXTEND, SEARCH");
        tool = scan.next();
        player.chooseTool(tool);
        if (!tool.equalsIgnoreCase("extend")) System.out.println("That's not the right tool!");
        } while (!tool.equalsIgnoreCase("extend"));

        if (player.extension>=1 && player.extension<=2) {
            System.out.println("You did it!");
            points += 5;
        } else {
            System.out.println("The pole was 1.5 meters away");
        }

        System.out.println("Now enter a negative number to pull it back");
        player.chooseTool(tool);
        if (player.extension > 0.5) {
            System.out.println("You had to pull harder");
        } else if (player.extension < -0.5) {
            System.out.println("You pulled too hard! Now it's broken");
        } else {
            System.out.println("Well done");
            points += 5;
        }
        System.out.println("Current score: " + points + " points");
    }
    
    void searchingChallenge(Robot player) {
        int num;
        int numOfBalls = 0;
        Boolean grab;
        System.out.println("Search the 5 Balls move it and the system will tell you if you need to go further or closer ");

        int random=(int)(Math.random()*10);
        num=scan.nextInt();

        do{
            player.search(num, random);
            while(num!=random);
            System.out.println("You find the ball, to grab it enter 'true' ");
            grab = scan.nextBoolean();
            if (grab) {
                numOfBalls+=1;
                System.out.println("Now return to your base");
                int r=(int)(Math.random()*12);
                System.out.println("move it and the system will tell you if you need to go further or closer");
                num=scan.nextInt();
                player.search(num, r);
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
