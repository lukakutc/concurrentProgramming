package tp4.Ej6;

import java.util.concurrent.Semaphore;

public class Taxi {
    // Recurso compartido

    Semaphore viajeDisponible = new Semaphore(1);
    Semaphore viajeTerminado = new Semaphore(0);

    public void despertarTaxista() {

        try {
            System.out.println("El cliente despertó al taxista");
            viajeDisponible.acquire();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void indicarDestino() {
        System.out.println("El pasajero indica destino al taxista");
        viajeTerminado.release();
    }

    public void viajeTerminado() {
        try {
            System.out.println("El taxista comienza el viaje");
            viajeTerminado.acquire();
            System.out.println("Termino el viaje ");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void bajarPasajero() {
        System.out.println("el pasajero se baja del auto");
        viajeDisponible.release();

    }

}
