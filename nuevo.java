import java.util.Scanner;
public class nuevo {
    public static void main(String[] args) throws Exception{
        Scanner scan=new Scanner(System.in);
        metodo llamar=new metodo();
        int num;
        int Numofballs=0;
        Boolean grab;
        System.out.println("Search the 5 Balls move it and the system will tell you if you need to go further or closer ");

        int random=(int)(Math.random()*10);
        num=scan.nextInt();

        do{
            llamar.search(num, random);
            while(num!=random);
            System.out.println("You find the ball, to grab it enter 'true' ");
            grab=scan.nextBoolean();
            if (grab==true){
                Numofballs+=1;
                System.out.println("Now return to your base");
                int r=(int)(Math.random()*12);
                System.out.println("move it and the system will tell you if you need to go further or closer");
                num=scan.nextInt();
                llamar.search(num, r);
            }
            else{
                System.out.println("You must grab the ball");
            }
            System.out.println("You find the base, now drop the ball ");
            if(grab==false){
                System.out.println("You must leave the ball");
            }
            else{
                System.out.println("Now search for more balls");
            }
        }
        while(Numofballs!=5);
        System.out.println("You did it");
        
        scan.close();
    }
}
