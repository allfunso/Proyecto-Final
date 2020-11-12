public class Robot {
    private int numOfBalls = 0;
    private boolean isHolding = false;
    private int height = 0;
    private int shootingAngle = 0;
    private int relativeDistance = 20;

    void move(int displacement) {
        relativeDistance -= displacement;
        System.out.println(relativeDistance);
    }
    void aim(int angle) {
        shootingAngle = angle;
    }
    void shoot(int force) {
        if (numOfBalls > 0) {
            System.out.println("You are shooting with a force of " + force + " newtons and " + shootingAngle +"° angle");
        } else {
            System.out.println("You don't have enough balls!");
        }
    }
    void pick() {
        numOfBalls += 1;
        System.out.println("You have " + numOfBalls + " balls");
    }
    void hold() {
        isHolding = true;
        System.out.println("Is holding: " + isHolding);
    }
    void release() {
        isHolding = false;
        System.out.println("Is holding: " + isHolding);
    }
    void elevate(int increment) {
        height += increment;
        System.out.println("New height: " + height);
    }
    void push() {
        //Push or sth
    }
}
