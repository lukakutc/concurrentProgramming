package tp8.ej1Sem;

import java.util.concurrent.Semaphore;

public class Recinto {
    // Recurso compartido
    private Semaphore semMostradorAlmuerzo;
    private Semaphore semAbridor;
    private Semaphore semMostradorPostre;

    public Recinto() {
        semMostradorAlmuerzo = new Semaphore(5);
        semAbridor = new Semaphore(1);
        semMostradorPostre = new Semaphore(3);
    }


    public void agarrarBandeja(){
        try {
            semMostradorAlmuerzo.acquire();
            System.out.println("Soldado "+Thread.currentThread().getName()+" agarro bandeja de almuerzo");
        } catch (InterruptedException e) {
        }
    }
    public void dejarBandeja(){
        System.out.println("Soldado "+Thread.currentThread().getName()+" deja la bandeja de almuerzo");
        semMostradorAlmuerzo.release();
    }

    public void agarrarPostre(){
        try {
            semMostradorPostre.acquire();
            System.out.println("Soldado "+Thread.currentThread().getName()+" agarro bandeja de postre");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void dejarPostre(){
        System.out.println("Soldado "+Thread.currentThread().getName()+" deja bandeja de postre");
        semMostradorPostre.release();
    }

    public void usarAbridor(){
        try {
            semAbridor.acquire();
            System.out.println("Soldado "+Thread.currentThread().getName()+" esta usando el abridor");
            Thread.sleep((long) (Math.random()*500));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void dejarAbridor(){
        System.out.println("Soldado "+Thread.currentThread().getName()+" deja el abridor");
        semAbridor.release();
    }

}