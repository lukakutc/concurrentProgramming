package tp2.ej6;

public class Corredor implements Runnable {
    private String nombre;
    private int distanciaRecorrida;
    private Meta meta;

    public Corredor(String nombre, Meta meta) {
        this.nombre = nombre;
        distanciaRecorrida = 0;
        this.meta = meta;
    }

    public void run() {
        while (distanciaRecorrida < 100) {
            distanciaRecorrida = distanciaRecorrida + (int) (Math.random() * 10);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
            System.out.println("Corredor "+nombre+": "+distanciaRecorrida+" pasos!");
        }
        meta.terminoCarrera(distanciaRecorrida, nombre);
    }
}