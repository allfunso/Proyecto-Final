public class metodo {
    int search (int n, int random){

        if(n>random){
            System.out.println("you passed, try behind");
        }
        if(n<random){
            System.out.println("you need to advance more");
        }
        return n;
    }  
}
