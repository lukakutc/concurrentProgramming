package tp5SEM.ej1;

import java.util.concurrent.Semaphore;

public class GestorPiscina {
    //Recurso compartido
    Semaphore piscina;
    Semaphore mutexEnt;
    Semaphore mutexSal;

    public GestorPiscina(){
        piscina = new Semaphore(30);
        mutexEnt = new Semaphore(1);//pa que entren de a uno
        mutexSal = new Semaphore(1);//pa que salgan de a uno
        //Esto es si la piscina tiene una entrada y una salida
    }

    public void entrar(){
        try {
            mutexEnt.acquire();
            System.out.println(Thread.currentThread().getName()+" Entro en la piscina");
            piscina.acquire();
        } catch (InterruptedException e) {
        }
        mutexEnt.release();
    }

    public void salir(){
        try {
            mutexSal.acquire();
            piscina.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" Salio de la piscina");
        mutexSal.release();
    }
}
