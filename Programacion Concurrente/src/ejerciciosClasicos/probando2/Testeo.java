package ejerciciosClasicos.probando2;

public class Testeo {
    public static void main(String[] args) {
        SyncCounter contador = new SyncCounter();

        Thread hilo1 = new Hilo1(contador);
        Thread hilo2 = new Hilo2(contador);
        
        
        hilo1.start();
        hilo2.start();
    }
}
