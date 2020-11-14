import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner mainScan = new Scanner(System.in);
        Robot robot = new Robot();
        Retos retos = new Retos();
        
        retos.shootingChallenge();
        retos.defendingChallenge();
        retos.clawChallenge();
        
        mainScan.close();
        retos.scan.close();
    }
}
