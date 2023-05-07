import java.util.Scanner;

public class Cajero {
    
    static float random1;
    static float random2;
    static float tiempoEntreLlegada;
    static float momentoDeLlegada=0;
    static float tiempoIniciaServicio=0;
    static float tiempoEspera;
    static String operacion;  
    static int tiempoDeOperacion;
    static float tiempoTerminaServicio=0;
    static boolean cajeroOcupado=false;
    static Scanner sc=new Scanner(System.in);

    public static void montecarlo(float random){
        if(random <= 0.25){
            operacion="Consulta de saldo";
            tiempoDeOperacion=80;
        }
        else if(random > 0.25 && random <=0.5){
            operacion="Otros";
            tiempoDeOperacion=50;
        }
        else if(random > 0.5 && random <= 0.85){
            operacion="Retiros";
            tiempoDeOperacion=120;
        }
        else{
            operacion="Transferencia";
            tiempoDeOperacion=60;
        }
    }

    public static void tabla(){
        random1=(float) Math.random();
        tiempoEntreLlegada=(float)((-Math.log(1 - random1) / 30) * 60);
        momentoDeLlegada+=tiempoEntreLlegada;
        if(tiempoTerminaServicio > momentoDeLlegada){
            tiempoIniciaServicio=tiempoTerminaServicio;
        }
        else{
            tiempoIniciaServicio=momentoDeLlegada;    
        }
        tiempoEspera = tiempoIniciaServicio - momentoDeLlegada;
        random2=(float) Math.random();
        montecarlo(random2);
        tiempoTerminaServicio = tiempoIniciaServicio + tiempoDeOperacion;
    }

    public static void main(String[] args) {
        int x=0;
        int n;
        while (x != 1) {
            System.out.println("Ingrese el valor de n:");
            n=sc.nextInt();
            for(int i=0; i<n; i++){
                System.out.format("%8s %15s %20s %20s %20s %20s %15s %20s %20s %24s", "Usuario", "#alea1", "T. entre llegada", "Momento de llegada",
                    "T. inicia servicio", "T. espera/atencion", "#alea2", "Operación", "T. de operación", "T. termina servicio \n");
                for (int j = 0; j < 100; j++) {
                    tabla();
                    System.out.format("%8s %15s %20s %20s %20s %20s %15s %20s %20s %24s", j+1, random1, tiempoEntreLlegada, momentoDeLlegada,
                        tiempoIniciaServicio, tiempoEspera, random2, operacion, tiempoDeOperacion, tiempoTerminaServicio + "\n");
                }
                System.out.println();
                momentoDeLlegada=0;
                tiempoIniciaServicio=0;
                tiempoTerminaServicio=0;
            }
            System.out.println("Ingrese 1 si desea salir:");
            x=sc.nextInt();
        }
    }
}
