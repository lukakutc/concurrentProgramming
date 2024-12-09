package TPFinal.atracciones.atraccion2;

import java.util.concurrent.Exchanger;

public class JuegosDePremio {
    private Exchanger<String> intercambio;

    public JuegosDePremio() {
        intercambio = new Exchanger<String>();
    }

    public void jugar(String nombre) {
        try {
            String ficha = "ficha";
            System.out.println("El visitante " + nombre + " quiere jugar");
            String premio = intercambio.exchange(ficha); // Aca se duerme el hilo hasta encontrar visitante hasta
                                                         // encontrar un Encargado que acepte su ficha
            System.out.println("El premio obtenido por el visitante es: " + premio);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void entregarPremio(String nombre){
        try {
            String premio;
            int puntos = (int) (Math.random()*5);
            switch (puntos) {
                case 1 -> premio = "Premio Pequeño";
                case 2 -> premio = "Premio Mediano";
                case 3 -> premio = "Premio Grande";
                case 4 -> premio = "Premio Súper Grande";
                case 5 -> premio = "Premio Especial";
                default -> premio = "Sin premio";
            }
            String ficha = intercambio.exchange(premio);
            System.out.println(nombre+"recibió la ficha, y entrega el premio");
        } catch (InterruptedException e) {
        }
    }
}