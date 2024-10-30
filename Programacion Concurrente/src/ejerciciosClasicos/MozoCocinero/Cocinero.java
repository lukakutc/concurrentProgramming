package ejerciciosClasicos.MozoCocinero;

public class Cocinero implements Runnable {
    private Comida c;

    public Cocinero (Comida c){
        this.c = c;
    }

    public void run(){
        c.esperarPedido();
        cocinarPedido();
        c.comidaLista();
    }

    public void cocinarPedido(){
        System.out.println("El cocinero esta cocinando la comida");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
