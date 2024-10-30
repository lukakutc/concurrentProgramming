package tp4.Ej7;

public class Mozo implements Runnable {
    private Lugar l;

    public Mozo (Lugar l){
        this.l = l;
    }

    public void run(){
        l.recibirPedido();
        cocinar();  
        l.entregarPedido();
    }

    public void cocinar(){
        System.out.println("El mozo le esta cocinando la comida al empleado");
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
        }
    }
    
}
