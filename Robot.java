import java.util.Scanner;

public class Robot {
    Scanner scan = new Scanner(System.in);

    double extension = 0;
    int position = 0;
    int shootingForce = 0;
    boolean isHolding = false;

    void chooseTool(String chosenTool) {
        switch (chosenTool.toLowerCase()) {
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
                extension += scan.nextDouble();
                System.out.println("The robot activates solenoids and moves its arm...");
                break;

            case "search":
                System.out.println("Your robot looks for a ball");
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
                
            default:
                System.out.println("That tool doesn't exist!");
                break;
        }
    }
    int search (int n, int random){

        if(n>random){
            System.out.println("you passed, try behind");
        }
        if(n<random){
            System.out.println("you need to advance more");
        }
        return n;
    }
}
