import java.util.Scanner;

public class Robot {
    Scanner scan = new Scanner(System.in);

    String tool;

    double extension = 0;
    double oilTemperature = 50;
    int position = 0;
    int searchPosition = 0;
    int shootingForce = 0;
    int forceg;
    boolean isHolding = false;

    void chooseTool() {
        System.out.println("SHOOT, MOVE, EXTEND, SEARCH, GRAB, SPIT, FLY, LASER");
        tool = scan.next().toLowerCase();
        switch (tool) {
            case "shoot":
                System.out.print("Enter a force (int): ");
                shootingForce = scan.nextInt();
                System.out.println("Your robot shoots a ball with " + shootingForce + "N of force");
                break;

            case "move":
                System.out.print("How far would you like to move? (int): ");
                position += scan.nextInt();
                System.out.println("Your robot moves...");
                break;
            
            case "extend":
                System.out.print("How far would you like to extend its arm? (double): ");
                double movement = scan.nextDouble();
                if (movement > 0) {
                    System.out.println("The robot activates solenoids and extends its arm");
                } else if (movement < 0) {
                    System.out.println("The robot activates solenoids and contracts its arm");
                } else {
                    System.out.println("The arm doesn't move. You had to enter a non-zero double");
                }
                extension += movement;
                break;

            case "search":
                System.out.print("Select the point you want to scan (int): ");
                searchPosition = scan.nextInt();
                System.out.println("Your robot looks for something at position " + searchPosition + "...");
                break;
                
            case "grab":
                if (isHolding) {
                    isHolding = false;
                    System.out.println("You were holding something, so you release it");
                } else {
                    isHolding = true;
                    System.out.println("You have picked something up");
                }
                break;
            
            case "spit":
                System.out.print("Enter a temperature in celsius: ");
                oilTemperature = scan.nextDouble();
                System.out.println("Your robot spits oil at " + oilTemperature + "° celsius");
                break;
                
            case "fly":
                System.out.println("Enter the impulse of the jetpack (int): ");
                forceg = scan.nextInt();
                if (forceg > 0) {
                    System.out.println("The robot begins to fly as it scorches the floor");
                } else {
                    System.out.println("Please enter a positive integer in order to activate the jetpack");
                }
                break;
                
            default:
                System.out.println("That tool doesn't exist!");
                break;
        }
    }
    
    int search (int n, int random) {

        if(n>random){
            System.out.println("you passed, try behind");
        }
        if(n<random){
            System.out.println("you need to advance more");
        }
        return n;
    }
    
    int aim(int x, int position) {
        if(x>position){
            System.out.println("you passed, try lower");
        }
        if(x<position){
            System.out.println("almost close, try higher");
        }
        return x;
    }
}
