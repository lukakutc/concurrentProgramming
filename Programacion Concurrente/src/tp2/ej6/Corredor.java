package tp2.ej6;

public class Corredor implements Runnable {
    private String nombre;
    private int distanciaRecorrida;

    public Corredor(String nombre) {
        this.nombre = nombre;
        distanciaRecorrida = 0;
    }

    public void run() {
        while (distanciaRecorrida < 100) {
            distanciaRecorrida = distanciaRecorrida + (int) (Math.random() * 10);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
            System.out.println("Corredor "+nombre+": "+distanciaRecorrida+" pasos!");
        }
        System.out.println("Llego a la meta!");
        System.out.println(distanciaRecorrida+ "pasos realizados!");
    }
}