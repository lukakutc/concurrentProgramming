package TPFinal.atracciones.atraccion2;

public class Visitante implements Runnable {
    JuegosDePremio juego;

    public Visitante(JuegosDePremio juego) {
        this.juego = juego;
    }

    public void run() {
        while (true) {
            // System.out.println("visitante quiere jugar");
            juego.jugar("visitante");
            // System.out.println("Ya jugo?");
        }

    }

}
