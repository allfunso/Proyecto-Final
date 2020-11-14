import java.util.Scanner;

public class Retos {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int force;
        System.out.println("Enter your force");

        for(int numOfBalls=4; numOfBalls>0; numOfBalls--){
            force = scan.nextInt();
            if(force>=60 && force<70){
                System.out.println("Too high! you failed");
            }
            if(force>50 && force<60){
                System.out.println("you hit it! just above the center");
            }
            if(force==50){
                System.out.println("You nailed it!");
            }
            if(force>=40 && force<50){
                System.out.println("You hit it! just below the center");
            }
            if(force>=30 && force<40){
               System.out.println("Very low! you failed");
            }
            System.out.println("Try again");
        }
        System.out.println("You get ran out fo balls");
        scan.close();
    }
}
