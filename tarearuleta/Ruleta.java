package tarearuleta;

public class Ruleta{

    public static String monteCarlo(){
        double aleatorio=Math.random();
        if (aleatorio<0.454545){
            return "rojo";
        }
        if(aleatorio>0.454545 && aleatorio<0.909090){
            return "negro";
        }
        else{
            return "verde";
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<22; i++){
            System.out.println(monteCarlo());
        }
    }
}