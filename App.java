import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("There is a target 3 meters high and 20 meters away");
        System.out.println("You can MOVE, AIM, SHOOT, PICK, HOLD, RELEASE, ELEVATE, PUSH");
        String selectedOption = scan.next();
        System.out.println("You selected " + selectedOption);
        
        scan.close();
    }
}
