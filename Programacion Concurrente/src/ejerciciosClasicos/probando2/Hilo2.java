package ejerciciosClasicos.probando2;

public class Hilo2 extends Thread{
    private SyncCounter counter;

    public Hilo2(SyncCounter counter){
        this.counter = counter;
    }

    public void run(){
        int i;
        for(i=0;i<5;i++){
            counter.decrement();
        }
    }

    
}