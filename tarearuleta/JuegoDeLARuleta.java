package tarearuleta;

import java.util.Scanner;

public class JuegoDeLARuleta {

    public static int DINERO_INICIAL = 200;
    public static int PRIMER_APUESTA = 1;
    static Jugador jugador1=new Jugador("Jugador1", "rojo", "igual", DINERO_INICIAL, PRIMER_APUESTA);
    static Jugador jugador2=new Jugador("Jugador2", "rojo", "doble", DINERO_INICIAL, PRIMER_APUESTA);
    static Scanner sc=new Scanner(System.in);
    public static float aleatorio;

    public static void casoEspecialVerde(Jugador j, int i){
        System.out.println("CASO ESPECIAL VERDE:");
        String gano="nulo";
        String usd1000="No";
        String exito="";
        int antes=j.getDinero();
        int apuesta=j.getApuesta();
        String result="verde";
        while(result.equals("verde")){
            result=monteCarlo();
            if(!result.equals(j.getColorApostado()) && !result.equals("verde")){
                int nuevoDinero=j.getDinero() - j.getApuesta();
                j.setDinero(nuevoDinero);
                gano="No";
                if(j.getEstrategia().equals("doble")){
                    int nuevaCantidadDeApuesta= 2 * j.getApuesta();
                    j.setApuesta(nuevaCantidadDeApuesta);
                    if(j.getApuesta() >= j.getDinero()){
                        j.setApuesta(j.getDinero());
                    }
                    if(j.getApuesta() >= 1000){
                        j.setApuesta(PRIMER_APUESTA);
                    }
                }
            }
            if(j.getDinero() >=1000){
                usd1000="Si";
                exito="++";
            }
            System.out.format("%17s %17s %17s %17s %17s %17s %17s %17s %17s", i, antes, 
            apuesta, aleatorio, result, gano, j.getDinero(), usd1000, exito + "\n");
        }
        System.out.println("FIN CASO ESPECIAL VERDE");
    }

    public static String monteCarlo(){
        aleatorio=(float) Math.random();
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

    public static void juega(Jugador j, int i){
        String gano;
        String usd1000="No";
        String exito="";
        int antes=j.getDinero();
        int apuesta=j.getApuesta();
        String result=monteCarlo();
        boolean verde=false;
        if(j.getDinero()==0){
            return ;
        }
        if(result.equals(j.getColorApostado())){
            int nuevoDinero=j.getDinero() + j.getApuesta();
            j.setDinero(nuevoDinero);
            gano="Si";
        }
        else if(result.equals("verde")){
            gano="Nulo";
            verde=true;
        }
        else{
            int nuevoDinero=j.getDinero() - j.getApuesta();
            j.setDinero(nuevoDinero);
            gano="No";
            if(j.getEstrategia().equals("doble")){
                int nuevaCantidadDeApuesta= 2 * j.getApuesta();
                j.setApuesta(nuevaCantidadDeApuesta);
                if(j.getApuesta() >= j.getDinero()){
                    j.setApuesta(j.getDinero());
                }
                if(j.getApuesta() >= 1000){
                    j.setApuesta(PRIMER_APUESTA);
                }
            }
        }
        if(j.getDinero() >=1000){
            usd1000="Si";
            exito="++";
        }
        System.out.format("%17s %17s %17s %17s %17s %17s %17s %17s %17s", i, antes, 
        apuesta, aleatorio, result, gano, j.getDinero(), usd1000, exito + "\n");
        if(verde){
            casoEspecialVerde(j, i);
        }
    }

    public static void main(String[] args) {
        int x=0;
        while(x!=1){
            System.out.println("Ingrese la cantidad de iteraciones que desea realizar: ");
            int n=sc.nextInt();
            System.out.format("%17s", "JUGADOR1\n");
            System.out.format("%17s %17s %17s %17s %17s %17s %17s %17s %17s", "iteracion", "$ antes", 
            "Apuesta", "#alea", "Color?", "Ganó?", "$ despues", "usd 1000?", "exito++\n");
            for(int i=0; i<n; i++){
                juega(jugador1, i+1);
            }
            System.out.println();
            System.out.format("%17s", "JUGADOR2\n");
            System.out.format("%17s %17s %17s %17s %17s %17s %17s %17s %17s", "iteracion", "$ antes", 
            "Apuesta", "#alea", "Color?", "Ganó?", "$ despues", "usd 1000?", "exito++\n");
            for(int i=0; i<n; i++){
                juega(jugador2, i+1);
            }
            System.out.println("Ingrese un 1 para salir");
            x=sc.nextInt();
        }
    }
}
