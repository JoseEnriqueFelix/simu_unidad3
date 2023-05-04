package tarearuleta;
import java.util.*;

public class JuegoDeLARuleta {
    public static int DINERO_INICIAL = 200;
    public static int PRIMER_APUESTA = 1;
    static Jugador jugador1=new Jugador("Jugador1", "rojo", "igual", DINERO_INICIAL, PRIMER_APUESTA);
    static Jugador jugador2=new Jugador("Jugador2", "rojo", "doble", DINERO_INICIAL, PRIMER_APUESTA);
    static Scanner sc=new Scanner(System.in);
    public static float aleatorio;
    public static boolean flag=false;

    public static void casoEspecialVerde(Jugador j,Jugador k, int i){
        System.out.format("%106s", "CASO ESPECIAL VERDE\n");
        String gano="nulo";
        String jusd1000="No";
        String kusd1000="No";
        String jexito="";
        String kexito="";
        int antes=j.getDinero();
        int apuesta=j.getApuesta();
        int antes2 = k.getDinero();
        int apuesta2=k.getApuesta();
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
            if(!result.equals(k.getColorApostado()) && !result.equals("verde")){
                int nuevoDinero=k.getDinero() - k.getApuesta();
                k.setDinero(nuevoDinero);
                gano="No";
                if(k.getEstrategia().equals("doble")){
                    int nuevaCantidadDeApuesta= 2 * k.getApuesta();
                    k.setApuesta(nuevaCantidadDeApuesta);
                    if(k.getApuesta() >= k.getDinero()){
                        k.setApuesta(k.getDinero());
                    }
                    if(k.getApuesta() >= 1000){
                        k.setApuesta(PRIMER_APUESTA);
                    }
                }
            }
            if(j.getDinero()>=1000){
                jusd1000="Si";
                jexito="++";
            }
            if(k.getDinero()>=1000){
                kusd1000="Si";
                kexito="++";
            }
            System.out.format("%9s %8s %10s %15s %8s %8s %10s %9s %8s", i, antes, 
            apuesta, aleatorio, result, gano, j.getDinero(), jusd1000, jexito);
            System.out.format("%15s %8s %10s %15s %8s %8s %10s %9s %9s", i, antes2, 
            apuesta2, aleatorio, result, gano, k.getDinero(), kusd1000, kexito + "\n");
        }
        System.out.format("%108s", "FIN CASO ESPECIAL VERDE\n");
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

    public static void juega(Jugador j,Jugador k, int i){
        String gano;
        String jusd1000="No";
        String kusd1000="No";
        String jexito="";
        String kexito="";
        int antes=j.getDinero();
        int apuesta=j.getApuesta();
        int antes2=k.getDinero();
        int apuesta2=k.getApuesta();
        String result=monteCarlo();
        boolean verde=false;
        if(j.getDinero()==0 || j.getDinero()>=1000 || k.getDinero()==0 || k.getDinero()>=1000){
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
        if(k.getDinero()==0){
            return ;
        }
        if(result.equals(k.getColorApostado())){
            int nuevoDinero=k.getDinero() + k.getApuesta();
            k.setDinero(nuevoDinero);
            gano="Si";
        }
        else if(result.equals("verde")){
            gano="Nulo";
            verde=true;
        }
        else{
            int nuevoDinero=k.getDinero() - k.getApuesta();
            k.setDinero(nuevoDinero);
            gano="No";
            if(k.getEstrategia().equals("doble")){
                int nuevaCantidadDeApuesta= 2 * k.getApuesta();
                k.setApuesta(nuevaCantidadDeApuesta);
                if(k.getApuesta() >= k.getDinero()){
                    k.setApuesta(k.getDinero());
                }
                if(k.getApuesta() >= 1000){
                    k.setApuesta(PRIMER_APUESTA);
                }
            }
        }
        if(j.getDinero() >=1000){
            jusd1000="Si";
            jexito="++";
            if(j.getEstrategia().equals("doble")){
                flag=true;
            }
        }
        if(k.getDinero() >=1000){
            kusd1000="Si";
            kexito="++";
            if(k.getEstrategia().equals("doble")){
                flag=true;
            }
        }
        System.out.format("%9s %8s %10s %15s %8s %8s %10s %9s %8s", i, antes, 
        apuesta, aleatorio, result, gano, j.getDinero(), jusd1000, jexito);
        System.out.format("%15s %8s %10s %15s %8s %8s %10s %9s %9s", i, antes2, 
            apuesta2, aleatorio, result, gano, k.getDinero(), kusd1000, kexito + "\n");
        if(verde){
            casoEspecialVerde(j,k, i);
        }
    }

    public static void imprimirTabla(){
        
    }

    public static void main(String[] args) {
        int x=0;
        while(x!=1){
            System.out.format("%50s %100s", "JUGADOR1", "JUGADOR2\n");
            System.out.format("%1s %8s %10s %15s %8s %8s %10s %9s %8s", "iteracion", "$antes", 
            "Apuesta", "#alea", "Color?", "Ganó?", "$despues", "usd1000?", "exito++");
            System.out.format("%15s %8s %10s %15s %8s %8s %10s %9s %9s", "iteracion", "$antes", 
            "Apuesta", "#alea", "Color?", "Ganó?", "$despues", "usd1000?", "exito++\n");
            
            for(int i=0; i<1000; i++){
                juega(jugador1,jugador2, i+1);
            }
            String mensaje;
            if(flag){
                mensaje="En este caso la estrategia del segundo jugador ha sido mejor";
            }
            else {
                mensaje="En este caso la estrategia del primer jugador ha sido mejor";
            }
            System.out.println(mensaje + "\n");
            System.out.println();
            System.out.println("Ingrese un 1 para salir");
            x=sc.nextInt();
            jugador1.setApuesta(PRIMER_APUESTA);
            jugador1.setDinero(DINERO_INICIAL);
            jugador2.setApuesta(PRIMER_APUESTA);
            jugador2.setDinero(DINERO_INICIAL);
        }
    }
    
}