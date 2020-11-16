import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Se declaran los objetos con los que vamos a trabajar par poder llamar a sus métodos
        Scanner mainScan = new Scanner(System.in);
        Robot robot = new Robot();
        Retos retos = new Retos();

        //Se le pregunta al usuario cuantos retos desea hacer (número entero)
        System.out.println("How many challenges would you like to perform?");
        int numOfChallenges = mainScan.nextInt();

        /**
         * La siguiente parte del código se repite el número de veces que haya indicado el usuario
         * Cada vez que se repita se preguntará cuál reto desea hacer
         * Si ingresa un reto que no existe, el caso 'default' se ejecutará
         */
        for (int i=0; i<=numOfChallenges; i++) {
            System.out.println("Choose your challenge by typing one of the following");
            System.out.println("SHOOTING, DEFENDING, CLAW, SEARCHING");
            String challengeSelected = mainScan.next();
            switch (challengeSelected.toUpperCase()) {
                case "SHOOTING":
                    retos.shootingChallenge();
                    break;
        
                case "DEFENDING":
                    retos.defendingChallenge();
                    break;

                case "CLAW":
                    retos.clawChallenge();
                    break;

                case "SEARCHING":
                    retos.searchingChallenge();
                    break;

                default:
                    System.out.println("There's no such challenge");
                    break;
            }
        }
        //Se imprime el número de puntos acumulados
        System.out.println("You scored a total of " + retos.points + " points");

        //Se cierra el escáner de main y de retos
        mainScan.close();
        retos.scan.close();
    }
}
