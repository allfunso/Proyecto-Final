import java.util.Scanner;

public class Robot {
    Scanner scan = new Scanner(System.in);     //iniciamos un scan llamado scan

    String tool;

    double extension = 0;                      //iniciamos variables
    double oilTemperature = 50;
    int position = 0;
    int searchPosition = 0;
    int shootingForce = 0;
    int forceg;
    boolean isHolding = false;
    float laserAngle = 0;

    void chooseTool() {
        System.out.println("SHOOT, MOVE, EXTEND, SEARCH, GRAB, SPIT, FLY, LASER");      //mostramos las opciones disponibles
        tool = scan.next().toLowerCase();                                       
        switch (tool) {                                                                 //escogemos la herramienta correspondiente
            case "shoot":
                System.out.print("Enter a force (int): ");
                shootingForce = scan.nextInt();                                         //preguntamos con cuanta fuerza se va a disparar la pelota
                System.out.println("Your robot shoots a ball with " + shootingForce + "N of force");    //asignamos un valor a la fuerza de disparo
                break;

            case "move":
                System.out.print("How far would you like to move? (int): ");
                position += scan.nextInt();                                    //apartir de el lugar donde esta le indicamos hasta adonde avanzar
                if (position == 0) {
                    System.out.println("Your robot doesn't move. Enter a non-zero integer");       //si escribes cero el robot te marca error de lo contrario avanza
                } else {
                    System.out.println("Your robot moves to position " + position + "...");
                }
                break;
            
            case "extend":
                System.out.print("How far would you like to extend its arm? (double): ");           //te preguntan que tanto quieres extender el brazo
                double movement = scan.nextDouble();
                if (movement > 0) {
                    System.out.println("The robot activates solenoids and extends its arm");
                } else if (movement < 0) {
                    System.out.println("The robot activates solenoids and contracts its arm");      //si es positivo se expande de lo contrario de contrae
                } else {
                    System.out.println("The arm doesn't move. You had to enter a non-zero double");
                }
                extension += movement;
                break;

            case "search":
                System.out.print("Select the point you want to scan (int): ");              //te pregunta en que punto quieres buscar  
                searchPosition = scan.nextInt();
                System.out.println("Your robot looks for something at position " + searchPosition + "...");
                break;
                
            case "grab":
                if (isHolding) {
                    isHolding = false;                                                   //te pregunta si estas agarrando(true) o si sueltas(false) algo
                    System.out.println("You were holding something, so you release it");
                } else {
                    isHolding = true;
                    System.out.println("You have picked something up");
                }
                break;
            
            case "spit":
                System.out.print("Enter a temperature in celsius: ");
                oilTemperature = scan.nextDouble();                 //te pregunta a que temperatura quieres escupir el aceite
                System.out.println("Your robot spits oil at " + oilTemperature + "° celsius");
                break;
                
            case "fly":
                System.out.println("Enter the impulse of the jetpack (int): ");     //te pregunta que tan alto quieres volar 
                forceg = scan.nextInt();
                if (forceg > 0) {
                    System.out.println("The robot begins to fly as it scorches the floor");
                } else {
                    System.out.println("Please enter a positive integer in order to activate the jetpack");
                }
                break;

            case "laser":
                System.out.println("Enter an angle to aim (0-180): ");          //te pregunta a que angulo quieres apuntar
                laserAngle = scan.nextFloat();
                System.out.println("The robot aims its laser at " + laserAngle + "°");
                break;

            default:                                                        //si inttroduce una palabra que no este en el catalogo le marca error
                System.out.println("That tool doesn't exist!");
                break;
        }
    }
    
    void search (int n, int random) {                               //la extension de "search" si el numero es mayor al lugar te pone que te pasaste y si es menor necesitas avanzar
        if(n > random){                                                                
            System.out.println("you passed, try behind");
        }
        if(n < random){
            System.out.println("you need to advance more");
        }
    }
    
    void aim(int x, int position) {                                 //extension de "laser" significa que si el angulo es mayor te pone que te pasaste y si es menor que te falta
        if(x > position){
            System.out.println("Almost! Try a lower angle");
        }
        if(x < position){
            System.out.println("Close! Try higher");
        }
    }
}
