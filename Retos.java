import java.util.Random;

public class Retos {

    Random randomGenerator = new Random();
    int points = 0;

    void shootingChallenge(Robot player) {
        System.out.println("There's a target that you have to shoot");
        System.out.println("Choose between one of your tools to complete the challenge:");

        for(int numOfBalls=4; numOfBalls>0; numOfBalls--) {

            player.chooseTool();

            if (player.tool.equals("shoot")) {
                if (player.shootingForce > 60) {
                    System.out.println("Too high! you failed");
                }
                else if (player.shootingForce > 50) {
                    System.out.println("You hit it! just above the center");
                    points += 5;
                }
                else if (player.shootingForce == 50) {
                    System.out.println("You nailed it!");
                    points += 10;
                }
                else if (player.shootingForce >= 40) {
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

        for (int i=0; i<=4; i++) {
            
            player.chooseTool();

            if (player.tool.equals("move")) {
                if (distance > player.position) {
                    System.out.println("You are still too far away. Move forward");
                } else if (distance < player.position) {
                    System.out.println("You went too far. Type a negative integer to move backwards");
                } else {
                    System.out.println("You have blocked the robot succesfully");
                    points += (18-2*i);
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
        player.chooseTool();
        if (!player.tool.equals("extend")) System.out.println("That's not the right tool!");
        } while (!player.tool.equals("extend"));

        if (player.extension>=1 && player.extension<=2) {
            System.out.println("You did it!");
            points += 10;
        } else {
            System.out.println("Wrong! The pole was 1.5 meters away");
        }

        System.out.println("Now enter a negative number to pull it back");
        do {
            player.chooseTool();
            if (!player.tool.equals("extend")) System.out.println("That's not the right tool!");
        } while (!player.tool.equals("extend"));

        if (player.extension > 0.5) {
            System.out.println("You had to pull harder");
        } else if (player.extension < -0.5) {
            System.out.println("You pulled too hard! Now it's broken");
        } else {
            System.out.println("Well done");
            points += 10;
        }
        System.out.println("Current score: " + points + " points");
    }
    
    void searchingChallenge(Robot player) {
        int pointsAvailable = 25;
        int numOfBalls = 0;
        int ballPosition;
        System.out.println("Search the 3 Balls. The system will tell you if you need to go further or closer");

        do {
            player.searchPosition = 0;
            ballPosition = randomGenerator.nextInt(10);
            do {
                player.chooseTool();
                player.search(player.searchPosition, ballPosition);
                pointsAvailable--;
            } while (player.searchPosition != ballPosition);
            System.out.println("You find the ball! Grab it using one of your tools");

            player.isHolding = false;
            player.chooseTool();
            if (player.isHolding) {
                numOfBalls++;
                System.out.println("Now find your base using SEARCH");
                int r = randomGenerator.nextInt(12);
                System.out.println("The system will tell you if you need to go further or closer");
                do {
                    player.chooseTool();
                    player.search(player.searchPosition, r);
                    pointsAvailable--;
                } while (player.searchPosition != r);

                System.out.println("You found your base!");
                System.out.println("You are in your base. Now drop the ball");
                player.isHolding = true;
                player.chooseTool();
                if(player.isHolding){
                    System.out.println("You had to release the ball");
                    System.out.println("Now look for another ball");
                    pointsAvailable--;
                }
                else {
                    System.out.println("Well done!");
                }
            } else {
                System.out.println("You must have grabbed the ball using the GRAB tool");
                System.out.println("You'll have to look for another ball");
                pointsAvailable--;
            }
        }
        while(numOfBalls < 3);
        if (pointsAvailable > 0) {
            points += pointsAvailable;
        }
        System.out.println("You did it");
    }
    
    void discsChallenge(Robot player) {
        int pointsAvailable = 18;
        System.out.println("There's a disc in front of you");
        System.out.println("You must take it to the enemy base using your tools");

        player.isHolding = false;
        while (!player.isHolding) {
            
            player.chooseTool();
            if (!player.tool.equals("grab")) {
                System.out.println("You must pick it up first");
                pointsAvailable--;
            }
        }
        System.out.println("Now go to the other side");

        player.position = 0;
        int destination = randomGenerator.nextInt(15) + 5;
        while (player.position != destination) {
            player.chooseTool();
            if (!player.tool.equals("move")) System.out.println("That's not the right tool!");
            System.out.println("The destination is " + (destination - player.position) + " meters away");
            pointsAvailable--;
        }
        System.out.println("You've reached it, now release it");
        
        player.isHolding = true;
        while (player.isHolding) {
            player.chooseTool();
            if (!player.tool.equals("grab")) {
                System.out.println("That's not the right tool!");
                pointsAvailable--;
            }
        }
        if (pointsAvailable > 0) {
            points += pointsAvailable;
        }
        System.out.println("You have accumulated " + points + " points so far");
    }

    void battleChallenge(Robot player) {
        player.extension = 0;
        int pointsAvailable = 20;
        System.out.println("You'll have to face a robot in a dirty battle");
        System.out.println("There are no rules. What are you gonna do?");
        while (player.extension<2 || player.oilTemperature<90) {
            player.chooseTool();
            if (player.tool.equals("spit")) {
                if (player.extension < 2) {
                    System.out.println("The oil is not reaching the robot. Try to extend your arm higher");
                } else if (player.oilTemperature < 90) {
                    System.out.println("HINT: The oil in your robot is too cold to make any damage");
                }
            } else if (!player.tool.equals("extend")) {
                System.out.println("That tool won't work. Try something else");
            }
            pointsAvailable -= 2;
        }
        System.out.println("The hot oil reaches the other robot and burns it");
        if (pointsAvailable > 0) {
            points += pointsAvailable;
            System.out.println("You win!");
        }
        System.out.println("You currently have " + points + " points");
    }
    
    void jetpackChallenge(Robot player){
        player.forceg = 0;
        int forceRequired = 45;
        System.out.println("There is a platform on a high place that you have to reach");
        System.out.println("Use one of your tools to get on it");
        while (player.forceg != forceRequired) {
            player.chooseTool();
            if (player.forceg > forceRequired) {
                System.out.println("You must try slower");
            }
            else if (player.forceg < forceRequired) {
                System.out.println("You must try harder. Use your jetpack");
            }
            else {
                System.out.println("You nailed it!");
            }
        }
    }
    
    void skysearchingChallenge(Robot player){
        player.extension = 0;
        int numOfBalls = 0;
        int distance = 45;

        System.out.println("Search the 5 Balls move it and the system will tell you if you need to go higher or lower ");
        System.out.println("Enter your aceleration of the jetpack");

        do{
            do {
                player.chooseTool();
                player.search(player.forceg, distance);
            } while(player.forceg!=distance);
            System.out.println("You find the ball. Grab it using one of your tools");
            player.chooseTool();
            if (player.isHolding) {
                numOfBalls+=1;
                System.out.println("Now return to your base");
                int r = randomGenerator.nextInt(12);
                System.out.println("move it and the system will tell you if you need to go further or closer");
                player.chooseTool();
                player.search(player.forceg, r);
            }
            else {
                System.out.println("You must grab the ball");
            }
            System.out.println("You find the base, now drop the ball ");
            if(!player.isHolding){
                System.out.println("You must leave the ball");
            }
            else{
                System.out.println("Now search for more balls");
            }
        }
        while(numOfBalls!=5);
        System.out.println("You did it");
    }
    
    void killenemiesChallenge(Robot player){
        int enemyLife = 30;
        int enemyPosition;
        int myLife = 30;

        System.out.println("Shoot your enemies, otherwise they will shoot you");
        System.out.println("Search your enemies");
        enemyPosition = randomGenerator.nextInt(6);
        do{
            player.chooseTool();
            
            if (player.tool.equals("laser")) {
                int transformedAngle = Math.round(player.laserAngle / 30f);
                player.aim(transformedAngle, enemyPosition);
                if (player.laserAngle != enemyPosition){
                    myLife -= 5;
                    System.out.println("You missed");
                }
                if (transformedAngle == enemyPosition){
                    enemyLife -= 10;
                    System.out.println("You shot him");
                    enemyPosition = randomGenerator.nextInt(6);
                }
            }
        }
        while(enemyLife>0 && myLife>0);
    }
}
