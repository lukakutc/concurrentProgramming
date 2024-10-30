package ejerciciosClasicos.MozoCocinero;

import java.util.concurrent.Semaphore;

public class Comida {
    // Este es el recurso compartido
    Semaphore pedido = new Semaphore(0);
    Semaphore comidaLista = new Semaphore(0);

    public Comida() {
    }

    // abba o rendevouz
    public void esperarPedido() {
        // Cocinero
        try {
            pedido.acquire();
            System.out.println("El cocinero obtiene el pedido del mozo");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void comidaLista() {
        System.out.println("El cocinero termino de cocinar la comida");
        comidaLista.release();
    }

    public void esperarComidaLista() {
        try {
            comidaLista.acquire();
            System.out.println("El mozo lleva la comida lista al cliente");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void generarPedido() {
        System.out.println("El mozo genera el pedido al cocinero");
        pedido.release();
    }
}
