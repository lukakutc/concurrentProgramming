package TPFinal.atracciones.atraccion2;

public class Encargado implements Runnable {
    private JuegosDePremio juego;
    private String nombre;

    public Encargado(JuegosDePremio juego) {
        this.juego = juego;
        nombre = "Encargado";
    }

    public void run(){
        while(true){
            juego.entregarPremio(nombre);
        }
    }

    
}
