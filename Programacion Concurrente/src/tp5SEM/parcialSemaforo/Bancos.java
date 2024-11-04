package tp5SEM.parcialSemaforo;

import java.util.concurrent.Semaphore;

public class Bancos {
    //Recurso compartido
    private Semaphore semBancos;
    private Semaphore pedirComida;
    private Semaphore comidaLista;
    private Semaphore mutex;
    private int bancosLibres;
    

    public Bancos(){
        semBancos = new Semaphore(4);
        pedirComida = new Semaphore(0);
        comidaLista = new Semaphore(0);
        mutex = new Semaphore(1);
        bancosLibres=4;
    }
    public void sentarse(){
        //menor
        try {
            semBancos.acquire(1);
            mutex.acquire();
            bancosLibres--;
            mutex.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Animalito "+ Thread.currentThread().getName()+" se sento en el banquito");
        System.out.println("Le pide comida a su hermano mayor");
        pedirComida.release();
        try {
            comidaLista.acquire();
            System.out.println("Animalito"+Thread.currentThread().getName()+" comiendo");
            Thread.sleep(8000);
            System.out.println("Animalito"+Thread.currentThread().getName()+ "termino de comer");
            semBancos.release();
            mutex.acquire();
            bancosLibres++;
            mutex.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void cocinarComida(){
        //mayor
        try {   

            pedirComida.acquire();
            System.out.println("Hermano mayor cocinando comida...");
            Thread.sleep(5000);
            System.out.println("Comida servida");
            comidaLista.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
