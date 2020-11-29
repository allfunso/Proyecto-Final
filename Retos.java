import java.util.Random;

public class Retos {
    //Se crea un generador de números aleatorios y una variable que almacena los puntos
    Random randomGenerator = new Random();
    int points = 0;

    /** Cada uno de los retos que puede elegir el jugador está en un método
    * Los métodos son de tipo void porque no deben retornar ningún valor, solo realizar las condiciones y salidas
    * Las herramientas se llaman de la clase robot, por lo que se debe pasar un argumento de tipo robot en cada método
    */
    void shootingChallenge(Robot player) {
        //Instrucciones
        System.out.println("There's a target that you have to shoot");
        System.out.println("Choose between one of your tools to complete the challenge:");

        //Lo siguiente se ejecuta hasta que el robot se quede sin pelotas
        for(int numOfBalls=4; numOfBalls>0; numOfBalls--) {

            player.chooseTool(); //Permitir la elección de herramienta

            //Si la herramienta es shoot, la fuerza de lanzamiento se clasificará con las siguientes condiciones
            if (player.tool.equals("shoot")) {
                if (player.shootingForce > 60) {
                    System.out.println("Too high! you failed");
                }
                else if (player.shootingForce > 50) {
                    System.out.println("You hit it! just above the center");
                    points += 5; //Se agregan puntos
                }
                else if (player.shootingForce == 50) {
                    System.out.println("You nailed it!");
                    points += 10; //Se agregan puntos
                }
                else if (player.shootingForce >= 40) {
                    System.out.println("You hit it! just below the center");
                    points += 5; //Se agregan puntos
                }
                else {
                   System.out.println("Very low! you failed");
                }
            } else {
                //Se advierte que la herramienta no es la adecuada si no usó SHOOT
                System.out.println("That's not the tool you should've used");
            }
            if (numOfBalls > 1) {
                //Se escribe que lo intente otra vez en caso de que aun pueda
                System.out.println("Try again");
            }
        }
        System.out.println("You ran out of balls");
        System.out.println("You've scored " + points + " points so far"); //Notifica los puntos que ha obtenido hasta ahora
    }

    void defendingChallenge(Robot player) {
        //Se coloca el robot en el inicio
        player.position = 0;

        //Se coloca el robot enemigo en una posición aleatoria y adelante
        int distance = randomGenerator.nextInt(10) + 5;
        System.out.println("There is a robot a few meters away");
        System.out.println("Choose between one of your tools to block it");

        //Se le dan oportunidades para que intente bloquear el robot
        for (int i=0; i<=4; i++) {
            
            player.chooseTool(); //Usuario elige herramienta

            //En caso de que haya elegido move, se verifica que tan lejos está del enemigo o si lo ha alcanzado
            if (player.tool.equals("move")) {
                if (distance > player.position) {
                    System.out.println("You are still too far away. Move forward");
                } else if (distance < player.position) {
                    System.out.println("You went too far. Type a negative integer to move backwards");
                } else {
                    System.out.println("You have blocked the robot succesfully");
                    points += (18-2*i); //Se suman los puntos, pero penalizando por el número de veces que lo haya intentado
                    break;
                }
            } else {
                //Se advierte que no es la heramienta adecuada
                System.out.println("That's not the tool you should've used");
            }
            //Se advierte que ya no tiene intentos disponibles
            if (i==3) System.out.println("You ran out of attempts");
        }
        //Se muestra el puntaje acumulado hasta ahora
        System.out.println("You have scored " + points + " points so far");
    }

    void clawChallenge(Robot player) {
        //Se comienza con el brazo en posición 0
        player.extension = 0;

        //instrucciones
        System.out.println("There is a metal pole hanging over the robot");
        System.out.println("The robot must extend its arm to grab it");
        System.out.println("Choose a tool to do so");

        //Se le permite realizar varios intentos para elegir su herramienta hasta que sea la adecuada
        do {
        player.chooseTool();
        if (!player.tool.equals("extend")) System.out.println("That's not the right tool!");
        } while (!player.tool.equals("extend"));

        if (player.extension>=1 && player.extension<=2) {
            System.out.println("You did it!");
            points += 10; //El usuario ingreso una respuesta correcta y se agregan 10 puntos
        } else {
            System.out.println("Wrong! The pole was 1.5 meters away");
        }

        System.out.println("Now enter a negative number to pull it back");
        do {
            player.chooseTool();
            if (!player.tool.equals("extend")) System.out.println("That's not the right tool!");
        } while (!player.tool.equals("extend"));

        if (player.extension > 0.5) {
            System.out.println("You had to pull harder");
        } else if (player.extension < -0.5) {
            System.out.println("You pulled too hard! Now it's broken");
        } else {
            System.out.println("Well done");
            points += 10; //El usuario ingresó una respuesta correcta y se agregan puntos
        }
        //Se imprime el puntaje actual
        System.out.println("Current score: " + points + " points");
    }
    
    void searchingChallenge(Robot player) {
        //Se definen puntos disponibles, numero de bolas y la posición de la bola
        int pointsAvailable = 25;
        int numOfBalls = 0;
        int ballPosition;
        //Instrucción
        System.out.println("Search the 3 Balls. The system will tell you if you need to go further or closer");

        do {
            //Se coloca el escáner del jugador en posición 0
            player.searchPosition = 0;
            //Se coloca la bola en una posición aleatoria de 0 a 10
            ballPosition = randomGenerator.nextInt(10);
            System.out.println("Look for a ball");
            do {
                player.chooseTool();
                player.search(player.searchPosition, ballPosition);
                pointsAvailable--; //Se penaliza por cada respuesta incorrecta
            } while (player.searchPosition != ballPosition);
            System.out.println("You find the ball! Grab it using one of your tools");

            //El jugador comienza sin agarrar nada
            player.isHolding = false;
            player.chooseTool();
            //Si logra tomar la pelota, se ejecuta el siguiente código
            if (player.isHolding) {
                numOfBalls++; //Se cuenta la pelota que ha tomado
                System.out.println("Now find your base using SEARCH");
                int r = randomGenerator.nextInt(12); //La posición de la base será un número aleatorio de 0 a 12
                System.out.println("The system will tell you if you need to go further or closer");
                //Se le dan varias oportunidades para buscar su base
                do {
                    player.chooseTool();
                    player.search(player.searchPosition, r);
                    pointsAvailable--; //Se penaliza por cada intento
                } while (player.searchPosition != r);
                //Una vez la haya encontrado, debe dejar la pelota
                System.out.println("You found your base!");
                System.out.println("You are in your base. Now drop the ball");
                player.isHolding = true;
                
                player.chooseTool();
                if(player.isHolding){
                    System.out.println("You had to release the ball");
                    System.out.println("Now look for another ball");
                    pointsAvailable--; //Se penaliza por no dejar la pelota
                }
                else {
                    System.out.println("Well done!");
                }
            } else {
                System.out.println("You must have grabbed the ball using the GRAB tool");
                System.out.println("You'll have to look for another ball");
                pointsAvailable--; //Se penaliza por no elegir la herramienta search
            }
        }
        while(numOfBalls < 3);
        //Se agreagan los puntos disponibles si es que los hay
        if (pointsAvailable > 0) {
            points += pointsAvailable;
        }
        //Se anuncia que ha ganado y los puntos que ha almacenado hasta el momento
        System.out.println("You did it");
        System.out.println("You currently have " + points + " points");
    }
    
    void discsChallenge(Robot player) {
        int pointsAvailable = 18;
        //Instrucciones
        System.out.println("There's a disc in front of you");
        System.out.println("You must take it to the enemy base using your tools");
        //Lo siguiente se ejecutará mientras no se use la herramienta grab
        player.isHolding = false;
        while (!player.isHolding) {
            player.chooseTool();
            if (!player.tool.equals("grab")) {
                System.out.println("You must pick it up first");
                pointsAvailable--;
            }
        }
        System.out.println("Now go to the other side");
        //El robot se coloca en la posición 0 y el destino entre 5 y 15
        player.position = 0;
        int destination = randomGenerator.nextInt(15) + 5;
        //Mientras no estén en la misma posición, 
        while (player.position != destination) {
            player.chooseTool();
            if (!player.tool.equals("move")) System.out.println("That's not the right tool!");
            System.out.println("The destination is " + (destination - player.position) + " meters away");
            pointsAvailable--; //Se penaliza por cada intento
        }
        System.out.println("You've reached it, now release it");
        
        player.isHolding = true;
        while (player.isHolding) {
            player.chooseTool();
            if (!player.tool.equals("grab")) {
                System.out.println("That's not the right tool!");
                pointsAvailable--; //Se penaliza por elegir la herramienta incorrecta
            }
        }
        //Si hay puntos disponibles, se agregan
        if (pointsAvailable > 0) {
            points += pointsAvailable;
        }
        //Se le recuerda cuantos puntos ha acumulado
        System.out.println("You have accumulated " + points + " points so far");
    }

    void battleChallenge(Robot player) {
        //Comienza con el brazo en posición 0
        player.extension = 0;
        int pointsAvailable = 20;
        //instrucciones
        System.out.println("You'll have to face a robot in a dirty battle");
        System.out.println("There are no rules. What are you gonna do?");
        //Para salir del ciclo, se debe extender el brazo y escupir aceite caliente
        while (player.extension<2 || player.oilTemperature<90) {
            player.chooseTool(); //Se permite que elija la herramienta
            if (player.tool.equals("spit")) {
                if (player.extension < 2) {
                    //Si escupe pero el brazo sigue sin estar extendido, se le informa que debe usar EXTEND
                    System.out.println("The oil is not reaching the robot. Try to extend your arm higher");
                } else if (player.oilTemperature < 90) {
                    //Si ingresa una temperatura baja, se informa que debe ser mayor
                    System.out.println("HINT: The oil in your robot is too cold to make any damage");
                }
            } else if (!player.tool.equals("extend")) {
                System.out.println("That tool won't work. Try something else");
                pointsAvailable -= 1; //Se penaliza por elegir herramientas incorrectas
            }
            pointsAvailable -= 1; //Se penaliza por cada intento
        }
        System.out.println("The hot oil reaches the other robot and burns it");
        //Se agregan los puntos disponibles si es que hay
        if (pointsAvailable > 0) {
            points += pointsAvailable;
            System.out.println("You win!");
        }
        //Se imprimen los puntos que ha acumulado hasta ahora
        System.out.println("You currently have " + points + " points");
    }
    
    void jetpackChallenge(Robot player) {
        //El jetpack comienza sin fuerza y se declara la fuerza que deberá tener
        player.forceg = 0;
        int forceRequired = 45;
        int pointsAvailable = 20;

        //Instrucciones
        System.out.println("There is a platform on a high place that you have to reach");
        System.out.println("Use one of your tools to get on it");
        //Se repite si la fuerza no es la requerida
        while (player.forceg != forceRequired) {
            player.chooseTool();
            if (player.forceg > forceRequired) {
                System.out.println("You must try slower");
            }
            else if (player.forceg < forceRequired) {
                System.out.println("You must try harder. Use your jetpack");
            }
            else {
                //La fuerza ha sido igual a la requerida
                System.out.println("You nailed it!");
            }
            pointsAvailable -= 2; //Se penaliza por cada intento
        }
        //Se agregan los puntos disponibles
        if (pointsAvailable > 0) {
            points += pointsAvailable;
        }
        //Se imprime el marcador actualizado
        System.out.println("You currently have " + points + " points");
    }
    
    //Este reto no se utiliza porque ya hay 8, pero decidimos incluirlo como easter egg ;)
    void skysearchingChallenge(Robot player){
        player.extension = 0;
        int numOfBalls = 0;
        int distance = 45;

        System.out.println("Search the 3 Balls move it and the system will tell you if you need to go higher or lower ");
        System.out.println("Enter your aceleration of the jetpack");

        do {
            do {
                player.chooseTool();
                player.search(player.forceg, distance);
            } while(player.forceg != distance);
            System.out.println("You find the ball. Grab it using one of your tools");
            player.chooseTool();
            if (player.isHolding) {
                numOfBalls += 1;
                System.out.println("Now return to your base");
                int r = randomGenerator.nextInt(12);
                System.out.println("move it and the system will tell you if you need to go further or closer");
                player.chooseTool();
                player.search(player.forceg, r);
            }
            else {
                System.out.println("You must grab the ball");
            }
            System.out.println("You find the base, now drop the ball ");
            if(!player.isHolding){
                System.out.println("You must leave the ball");
            }
            else{
                System.out.println("Now search for more balls");
            }
        }
        while(numOfBalls < 3);
        System.out.println("You did it");
    }
    
    void killenemiesChallenge(Robot player) {
        //Se declara vida del jugador y número de enemigos
        int numberOfEnemies = 3;
        int enemyPosition;
        int myLife = 40;
        int pointsAvailable = 20;
        //Instrucciones
        System.out.println("Shoot your enemies (3), otherwise they will shoot you");
        System.out.println("Search your enemies");
        //Se coloca al enemigo en una posición aleatoria del 0 al 6
        enemyPosition = randomGenerator.nextInt(6);

        do {
            player.chooseTool(); //Se permite que elija herramienta

            if (player.tool.equals("laser")) {
                //Se transforma el angulo (0 a 180) a un numero de 0 a 6
                int transformedAngle = Math.round(player.laserAngle / 30f);
                player.aim(transformedAngle, enemyPosition);
                if (transformedAngle != enemyPosition){
                    myLife -= 5;
                    System.out.println("You missed");
                    pointsAvailable--;
                } else {
                    numberOfEnemies -= 1;
                    System.out.println("You shot an enemy");
                    enemyPosition = randomGenerator.nextInt(6);
                }
            } else {
                //Se penaliza por usar una herramienta que no es el laser
                System.out.println("You should use another tool. Enemies are extremely photosensitive");
                pointsAvailable -= 2;
            }
        }
        while(numberOfEnemies>0 && myLife>0);
        //Se agregan los puntos que sigan disponibles
        if (pointsAvailable > 0) {
            points += pointsAvailable;
        }
        //Se imprime el marcador actual
        System.out.println("You've scored " + points + "points so far");
    }
}
