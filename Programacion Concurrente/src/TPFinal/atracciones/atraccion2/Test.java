package TPFinal.atracciones.atraccion2;

import java.util.concurrent.Exchanger;

public class Test {
    public static void main(String[] args) {
        JuegosDePremio j = new JuegosDePremio();

        new Thread(new Visitante(j)).start();
        new Thread(new Encargado(j)).start();
    }
    
    

}
