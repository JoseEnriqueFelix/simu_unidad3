package tarearuleta;

public class Jugador {
    
    private String nombre;
    private String colorApostado;
    private String estrategia;
    private int dinero;
    private int apuesta;

    public Jugador(String nombre, String colorApostado, String estrategia, int dinero, int apuesta){
        this.nombre=nombre;
        this.colorApostado=colorApostado;
        this.estrategia=estrategia;
        this.dinero=dinero;
        this.apuesta=apuesta;
    }

    public String getNombre(){
        return nombre;
    }

    public String getColorApostado(){
        return colorApostado;
    }

    public String getEstrategia(){
        return estrategia;
    }

    public int getDinero(){
        return dinero;
    }

    public void setDinero(int dinero){
        this.dinero=dinero;
    }

    public int getApuesta(){
        return apuesta;
    }

    public void setApuesta(int apuesta){
        this.apuesta=apuesta;
    }

    public String toString(){
        return "Nombre: " + nombre + ", color apostado: " + colorApostado + ", estrategia: " + estrategia + ", dinero: " + dinero + ", apuesta: " + apuesta;
    }
}
