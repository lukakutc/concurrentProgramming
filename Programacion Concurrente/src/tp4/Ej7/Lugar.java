package tp4.Ej7;

import java.util.concurrent.Semaphore;

public class Lugar {
    //Recurso compartido
    private Semaphore asiento = new Semaphore(1);
    private Semaphore pedido = new Semaphore(0);
    private Semaphore comida = new Semaphore(0);
    public Lugar(){}

    //e se sienta-> e pide -> m recibe pedido -> m cocina -> m entrega y espera -> e come -> e se va
    public void sentarse(){
        try {
            asiento.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("El empleado se ha sentado en el asiento");
    }

    public void pedir(){
        System.out.println("El empleado pide");
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