package tp8.ej4sem;
import java.util.concurrent.Semaphore;

public class Centro {
    //recurso compartido
    Semaphore semCamillas;
    Semaphore semRevistas;
    Semaphore mutex;
    int camillasLibres;

    public Centro(){
        
        semCamillas = new Semaphore(4,true);
        semRevistas = new Semaphore(9,true);
        mutex = new Semaphore(1);
        camillasLibres = 4;
    }

    public void entrarSala(){
        if(camillasLibres>0){
            try {
                
                semCamillas.acquire();
                mutex.acquire();
                camillasLibres--;
                mutex.release();
                System.out.println("La persona "+Thread.currentThread().getName()+" ocupo una camilla.");
                Thread.sleep((int) (Math.random()*1000));
                System.out.println("La persona "+Thread.currentThread().getName()+" libera una camilla");
                
                semCamillas.release();
                mutex.acquire();
                camillasLibres++;
                mutex.release();
            } catch (InterruptedException e) {
            }
        }else{
            try {
                semRevistas.acquire();
                System.out.println("La persona "+Thread.currentThread().getName()+" agarro una revista");
                
                semCamillas.acquire();
                mutex.acquire();
                camillasLibres--;
                mutex.release();
                System.out.println("La persona "+Thread.currentThread().getName()+" libera una revista y ocupa una camilla");
                semRevistas.release();
                Thread.sleep((int)(Math.random()*1000));
                System.out.println("La persona "+Thread.currentThread().getName()+" libera una camilla");
                
                semCamillas.release();
                mutex.acquire();
                camillasLibres++;
                mutex.release();
                
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }

}
