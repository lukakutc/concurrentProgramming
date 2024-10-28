package ejerciciosClasicos.probando2;

public class Hilo1 extends Thread{
    private SyncCounter counter;

    public Hilo1(SyncCounter counter){
        this.counter = counter;
    }

    public void run(){
        int i;
        for(i=0;i<10;i++){
            counter.increment();
        }
    }

    
}