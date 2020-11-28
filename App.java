import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        //Se declaran los objetos con los que vamos a trabajar par poder llamar a sus métodos
        Scanner mainScan = new Scanner(System.in);
        Robot robot = new Robot();
        Retos retos = new Retos();

        //Bienvenida e instrucciones
        System.out.println("Welcome to the robotics cometition, player");
        System.out.println("You'll have to face a series of challenges using 8 different tools:");
        System.out.println("    SHOOT: Asks for a force (int) and shoots a ball");
        System.out.println("    MOVE: Asks for a distance (int) and your robot moves (negative = backwards)");
        System.out.println("    EXTEND: Asks for a decimal number to extend (+) or contract (-) its arm");
        System.out.println("    SEARCH: Asks for an integer and looks for a ball at that point");
        System.out.println("    GRAB: Grabs something. In case the robot is already holding sth, it will be released");
        System.out.println("    SPIT: Releases oil at a certain temperature (double)");
        System.out.println("    FLY: Asks for an integer and the jetpack shoots you to the air!");
        System.out.println("    LASER: Asks for an angle (int) and aims\n--------------------------------");
        
        //Se le pregunta al usuario cuantos retos desea hacer (número entero)
        System.out.println("How many challenges would you like to perform?");
        int numOfChallenges = mainScan.nextInt();

        /**
         * La siguiente parte del código se repite el número de veces que haya indicado el usuario
         * Cada vez que se repita se preguntará cuál reto desea hacer
         * Si ingresa un reto que no existe, el caso 'default' se ejecutará
         */
        for (int i=1; i<=numOfChallenges; i++) {
            System.out.println("Choose your challenge by typing one of the following");
            System.out.println("SHOOTING, DEFENDING, CLAW, SEARCHING, DISCS, BATTLE, JETPACK, SKYSEARCHING, ENEMIES");
            String challengeSelected = mainScan.next();
            switch (challengeSelected.toUpperCase()) {
                case "SHOOTING":
                    retos.shootingChallenge(robot);
                    break;
        
                case "DEFENDING":
                    retos.defendingChallenge(robot);
                    break;

                case "CLAW":
                    retos.clawChallenge(robot);
                    break;

                case "SEARCHING":
                    retos.searchingChallenge(robot);
                    break;
                    
                case "DISCS":
                    retos.discsChallenge(robot);
                    break;

                case "BATTLE":
                    retos.battleChallenge(robot);
                    break;

                case "JETPACK":
                    retos.jetpackChallenge(robot);
                    break;

                case "SKYSEARCHING":
                    retos.skysearchingChallenge(robot);
                    break;

                case "ENEMIES":
                    retos.killenemiesChallenge(robot);
                    break;
                    
                default:
                    System.out.println("There's no such challenge");
                    break;
            }
        }

        //Se imprime el número de puntos acumulados
        System.out.println("\n-------- The game has finished --------\n");
        System.out.println("You scored a total of " + retos.points + " points");

        //Se cierra el escáner de main y robot
        mainScan.close();
        robot.scan.close();
    }
}
