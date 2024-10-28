package tp2.ej3;

public class RunnableEjemplo implements Runnable {
    public void run(){
        int i;
        for(i=0;i<10;i++){
            System.out.println(i+" "+ Thread.currentThread().getName());
        }
        System.out.println("Termina thread: "+Thread.currentThread().getName());
    }
}
