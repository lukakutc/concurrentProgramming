package tp4.ej3;

import java.util.concurrent.Semaphore;

public class HiloControlador {
    //Recurso compartido
    Semaphore P1 = new Semaphore(1);
    Semaphore P2= new Semaphore(0);
    Semaphore P3= new Semaphore(0);

    //el orden sera P1->P3->P2 y repetimos

    public HiloControlador(){}

    public void adquirirP1(){
        try {
            P1.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void liberarP1(){
        P1.release();
    }

    public void adquirirP2(){
        try {
            P2.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void liberarP2(){
        P2.release();
    }

    public void adquirirP3(){
        try {
            P3.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void liberarP3(){
        P3.release();
    }
}
