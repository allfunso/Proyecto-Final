import java.util.Scanner;

public class Retos {
    Scanner scan = new Scanner(System.in);

    private int points = 0;

    public void shootingChallenge() {
        int force;
        System.out.println("Enter your force");

        for(int numOfBalls=4; numOfBalls>0; numOfBalls--){
            force = scan.nextInt();
            if(force>=60 && force<70){
                System.out.println("Too high! you failed");
            }
            if(force>50 && force<60){
                System.out.println("you hit it! just above the center");
                this.points += 5;
            }
            if(force==50){
                System.out.println("You nailed it!");
                this.points += 10;
            }
            if(force>=40 && force<50){
                System.out.println("You hit it! just below the center");
                this.points += 5;
            }
            if(force>=30 && force<40){
               System.out.println("Very low! you failed");
            }
            System.out.println("Try again");
        }
        System.out.println("You ran out of balls");
        System.out.println("You scored " + this.points + " points");
    }

    public void defendingChallenge() {

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
                this.points += (10-2*i);
                break;
            }
            System.out.println("You have received " + this.points + " points");
        }
    }

    public void clawChallenge() {
        System.out.println("There is a metal pole hanging over the robot");
        System.out.println("The robot must extend its arm to grab it");
        System.out.println("How far would you like to extend its arm?");
        double extension = scan.nextDouble();
        if (extension>=1 && extension<=2) {
            System.out.println("You did it!");
            this.points += 5;
            System.out.println("Now enter a negative number to pull it back");
            extension -= scan.nextDouble();
            if (extension > 0.5) {
                System.out.println("You had to pull harder");
            } else if (extension < -0.5) {
                System.out.println("You pulled too hard! Now it's broken");
            } else {
                System.out.println("Well done");
                this.points += 5;
            }
        } else {
            System.out.println("The pole was 1.5 meters away");
            System.out.println("Maybe nex time");
        }
        System.out.println("You scored " + this.points + " points");
    }
}
