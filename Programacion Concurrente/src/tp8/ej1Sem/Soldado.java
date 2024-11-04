package tp8.ej1Sem;

public class Soldado implements Runnable {
    private Recinto r;

    public Soldado(Recinto r) {
        this.r = r;
    }

    public void run(){
        r.agarrarBandeja();
        r.usarAbridor();
        r.dejarAbridor();
        comer();
        r.agarrarPostre();
        comerPostre();
        r.dejarPostre();
        r.dejarBandeja();
    }

    public void comer(){
        System.out.println("El soldado "+Thread.currentThread().getName()+" esta almorzando");
        try {
            Thread.sleep((long) (Math.random()*1000));
            System.out.println("El soldado "+Thread.currentThread().getName()+" termino de almorzar");
        } catch (InterruptedException e) {
        }
        
    }
    public void comerPostre(){
        System.out.println("El soldado "+Thread.currentThread().getName()+" esta comiendo postre");
        try {
            Thread.sleep((long) (Math.random()*1000));
            System.out.println("El soldado "+Thread.currentThread().getName()+" termino de comer el postre");
        } catch (InterruptedException e) {
        }   
    }
    
}
