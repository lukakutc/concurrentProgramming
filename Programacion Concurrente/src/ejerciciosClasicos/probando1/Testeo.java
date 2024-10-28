package ejerciciosClasicos.probando1;

public class Testeo {
    public static void main(String[] args) {
        Thread h1 = new Thread(new procesoUno());
        Thread h2 = new Thread(new procesoDos());
        Thread h3 = new hilo3();

        h1.start();
        h2.start();
        h3.start();
    }
}
