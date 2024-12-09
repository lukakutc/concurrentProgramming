package TPFinal.atracciones.atraccion4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ControlTren {
    // Los visitantes esperan en la cola
    // Recurso compartido
    // uso locks, porque el tren tiene la condicion de viajar si esta llena la cola
    // o pasaron 5 minutos
    private int CAPACIDAD_COLA;
    private LinkedBlockingQueue cola;
    private Lock lock;
    private Condition puedeEmpezarRecorrido;
    private int esperando;
    private boolean puedeViajar;

    public ControlTren(int CAPACIDAD_COLA) {
        this.CAPACIDAD_COLA = CAPACIDAD_COLA;
        this.cola = new LinkedBlockingQueue<>(CAPACIDAD_COLA);
        this.lock = new ReentrantLock(true);
        this.puedeEmpezarRecorrido = lock.newCondition();
        esperando = 0;
        puedeViajar = false;
    }

    public void esperarTren(Visitante v) {
        try {
            System.out.println(v.getNombre() + " quiere hacer el recorrido en tren");
            cola.put(v);
            lock.lock();
            System.out.println(v.getNombre() + " espera en la cola del tren en posicion " + esperando);
            esperando++;
            if (esperando == 10) {
                puedeViajar = true;
                puedeEmpezarRecorrido.signal();
            }
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void empezarViaje() {
        // ya esta resuelta la interaccion de la cola, ahora hay que hacer singal al
        // puedeEmpezarRecorrido pero con el tiempo. El viajar es lo que ejecutura
        // El hilo tren en while true
        ScheduledExecutorService temporizador = Executors.newSingleThreadScheduledExecutor();
        temporizador.schedule(new HiloTemporizador(this), 5, TimeUnit.SECONDS);
        while (!puedeViajar) {
 
            try {
                puedeEmpezarRecorrido.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    public void avisarTiempoTerminado() {
        puedeEmpezarRecorrido.signal();
        puedeViajar = true;
    }

    public void terminarViaje() {

    }

}

// Fun
