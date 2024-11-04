package tp8.ej2sem;
import java.util.concurrent.Semaphore;

public class Observatorio {
    //Recurso compartido    
    Semaphore visitante = new Semaphore(50);   
    Semaphore mutex = new Semaphore(1);
    Semaphore investigador = new Semaphore(1);
    Semaphore grupoMantenimiento = new Semaphore(1);

    public Observatorio(){
    }

    public void entrarVisitante(){
        try {
            mutex.acquire();
            visitante.acquire();
            System.out.println("Entra visitante y observa esterllas");
            Thread.sleep(0);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
