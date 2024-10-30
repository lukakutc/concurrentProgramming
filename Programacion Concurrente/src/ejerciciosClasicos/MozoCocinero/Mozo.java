package ejerciciosClasicos.MozoCocinero;

public class Mozo implements Runnable {
    private Comida c;

    public Mozo(Comida c){
        this.c = c;
    }

    public void run(){
        esperarCliente();
        c.generarPedido();
        c.esperarComidaLista();
    }
    
    public void esperarCliente(){
        System.out.println("El cliente esta pidiendo");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
