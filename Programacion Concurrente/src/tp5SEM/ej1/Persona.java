package tp5SEM.ej1;

public class Persona implements Runnable {
    private GestorPiscina p;

    public Persona(GestorPiscina p){
        this.p = p;
    }

    public void  run(){
        p.entrar();
        bañarse();
        p.salir();
    }

    public void bañarse(){
        System.out.println(Thread.currentThread().getName()+" disfruta de la pileta");
        try {
            Thread.sleep((int) (Math.random()*1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
