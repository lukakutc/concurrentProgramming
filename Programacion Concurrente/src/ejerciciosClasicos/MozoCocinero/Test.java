package ejerciciosClasicos.MozoCocinero;

public class Test {
    public static void main(String[] args) {
        Comida c = new Comida();
    
        Thread cocinero = new Thread(new Cocinero(c));
        Thread mozo = new Thread(new Mozo(c));

        cocinero.start();
        mozo.start();
    }
}
