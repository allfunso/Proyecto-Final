import java.util.Scanner;
public class Proyecto {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int force;
        int numofballs=4;
        System.out.println(" enter your force");
        force=scan.nextInt();

        for(int i=0;numofballs>i;numofballs--){
            if(force>=60 && force<70){
                System.out.println("Too high! you failed");
                numofballs-=1;
            }
            if(force>50 && force<60){
                System.out.println("you hit it! just above the center");
                numofballs-=1;
            }
            if(force==50){
                System.out.println("You nailed it!");
                numofballs-=1;
            }
            if(force>=40 && force<50){
                System.out.println("You hit it! just below the center");
                numofballs-=1;
            }
            if(force>=30 && force<40){
               System.out.println("Very low! you failed");
               numofballs-=1;
            }
            System.out.println("Try again");
            force=scan.nextInt();
        }
        System.out.println("You get ran out fo balls");
        scan.close();
    }
}
