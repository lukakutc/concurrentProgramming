package ejerciciosClasicos.probando2;

public class SyncCounter {
    private int valor;

    public SyncCounter(){
        valor = 0;
    }

    public  synchronized void increment(){
        System.out.println("Hilo: "+Thread.currentThread()+" incrementando valor de contador");
        valor++;
    }
    public synchronized void decrement(){
        System.out.println("Hilo: "+Thread.currentThread()+" decrementando valor de contador.");
        valor--;
    }

    public int getValor(){
        return valor;
    }
}
