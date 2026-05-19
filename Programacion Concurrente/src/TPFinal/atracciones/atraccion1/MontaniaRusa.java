import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class MontaniaRusa {

    private final int CAPACIDAD = 5;
    private final int CAPACIDAD_ESPERA = 10;
    private final int FICHAS = 3;

    private Semaphore salaEspera;
    private Semaphore asientos;
    private CyclicBarrier barrera;

    public MontaniaRusa() {
        salaEspera = new Semaphore(CAPACIDAD_ESPERA);
        asientos = new Semaphore(CAPACIDAD);

        barrera = new CyclicBarrier(CAPACIDAD, () -> {
            try {
                System.out.println("\n>>> La montaña rusa inicia el viaje <<<");
                Thread.sleep(3000); // duración del viaje
                System.out.println(">>> El viaje terminó <<<\n");

                // liberar asientos para el próximo grupo
                asientos.release(CAPACIDAD);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void subir(int id) {
        try {
            System.out.println("Visitante " + id + " intenta entrar a la sala de espera");

            // intenta entrar a la sala de espera
            if (!salaEspera.tryAcquire()) {
                System.out.println("Visitante " + id + " no encontró lugar en espera y se fue");
                return;
            }

            System.out.println("Visitante " + id + " entró a la sala de espera");

            // espera asiento
            asientos.acquire();
            System.out.println("Visitante " + id + " subió a la montaña rusa");

            // deja libre lugar en sala de espera
            salaEspera.release();

            // espera a completar 5 pasajeros
            barrera.await();

            // después del viaje
            System.out.println("Visitante " + id + " bajó y recibió " + FICHAS + " fichas");

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
