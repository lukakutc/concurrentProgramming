package tp4.Ej7;

import java.util.concurrent.Semaphore;

public class Lugar {
    //Recurso compartido
    private Semaphore asiento = new Semaphore(1);
    private Semaphore pedido = new Semaphore(0);
    public Lugar(){}

    public void sentarse(){
        try {
            asiento.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("El empleado se ha sentado en el asiento y pide");
        pedido.release();
    }
    public void irse (){
        
        asiento.release();
        System.out.println("Se fue el empleado xq ya comio");
    }

    public void recibirPedido(){
        try {
            pedido.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("El mozo recibe el pedido");

    }

    public void entregarPedido(){
        System.out.println("mozo entrega pedido a empleado");
        pedido.release();
    }

}


//va por ahi pero hay que pensar simplemente bien como lo planteamos por las slaidas por pantalla y eso