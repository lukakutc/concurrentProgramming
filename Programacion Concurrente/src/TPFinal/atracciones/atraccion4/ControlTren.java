package TPFinal.atracciones.atraccion4;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ControlTren {
    private int CAPACIDAD_COLA; // Capacidad máxima de la cola
    private LinkedBlockingQueue<Visitante> cola; // Cola para los visitantes
    private Lock lock; // Lock para sincronización
    private Condition puedeEmpezarRecorrido; // Condición para iniciar el viaje
    private Condition puedeSubir;
    private Condition subieron; //
    private int esperando; // Número de visitantes en espera
    private boolean puedeViajar; // Bandera para controlar si el tren puede viajar
    private boolean subio;
    private boolean puedenSubir; // esta es la condicion de que los visitantes pueden subir

    public ControlTren(int CAPACIDAD_COLA) {
        this.CAPACIDAD_COLA = CAPACIDAD_COLA;
        this.cola = new LinkedBlockingQueue<>(CAPACIDAD_COLA);
        this.lock = new ReentrantLock(true);
        this.puedeEmpezarRecorrido = lock.newCondition();
        this.puedeSubir = lock.newCondition();
        this.subieron = lock.newCondition();

        esperando = 0; // Inicialmente no hay nadie esperando
        puedeViajar = false; // Por defecto, el tren no puede viajar

    }

    public void esperarTren(Visitante v) {
        try {
            System.out.println(v.getNombre() + " quiere hacer el recorrido en tren");
            cola.put(v); // El visitante se agrega a la cola
            lock.lock(); // Bloquea para sincronización
            esperando++;
            System.out.println(v.getNombre() + " espera en la cola del tren en posición " + esperando);

            // Si la cola se llena, activa la condición
            if (esperando == CAPACIDAD_COLA) {
                System.out.println("La cola está llena. El tren puede iniciar el viaje.");
                puedeViajar = true;
                puedeEmpezarRecorrido.signal(); // Señala que el tren puede viajar
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // Libera el lock
        }
    }

    public void empezarViaje() {
        // Inicia el temporizador para el tiempo límite de espera
        ScheduledExecutorService temporizador = Executors.newSingleThreadScheduledExecutor();
        temporizador.schedule(new HiloTemporizador(this), 5, TimeUnit.SECONDS);

        lock.lock(); // Bloquea para sincronización
        try {
            while (!puedeViajar) { // Espera hasta que pueda viajar
                System.out.println("El tren está esperando para iniciar el viaje...");
                puedeEmpezarRecorrido.await();
            }
            // la cola se lleno, o el tiempo transcurrió. Ahora hay que esperar que suban
            // los pasajeros
            puedenSubir = true;
            puedeSubir.signal();
            while(esperando>0){
                subieron.await();
            }
            System.out.println("Subieron todos los pasajeros");
            System.out.println("Empieza el viaje");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            temporizador.shutdown();
            lock.unlock(); // Libera el lock
        }
    }

    // Para poder simular en el hilo, dividir entre 3 como hicimos en parcial
    // empezarSubir, simular, terminarSubir. De esta forma podemos simular en hilo
    public void subirTren(Visitante v) {
        try {
            lock.lock();
            subio = false;
            while (!puedenSubir || !subio) {
                if (!v.equals(cola.peek())) {
                    // Si el visitante NO es el que debe subir, espera
                    puedeSubir.await();
                } else {
                    // Sino:
                    System.out.println("Visitante "+cola.peek().getNombre()+" empieza a subir al tren");
                    subio = true;// el visitante empieza a subir
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void terminarSubir() {
        try {
            System.out.println("Visitante "+cola.peek().getNombre()+" termina de subir al tren");
            cola.take();//Cuando termina de subir es sacado de la cola
            esperando--;
            puedeSubir.signal();
            if(esperando==0){
                subieron.signal();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // quitamos de la cola
            lock.unlock();
        }
    }

    public void avisarTiempoTerminado() {
        lock.lock();
        try {
            if (!puedeViajar) {
                System.out.println("Han pasado 5 segundos. El tren puede iniciar el viaje.");
                puedeViajar = true; // Activa la bandera para viajar
                puedeEmpezarRecorrido.signal(); // Señala que el tren puede viajar
            }

        } finally {
            lock.unlock(); // Libera el lock
        }
    }

    public void terminarViaje() {
        lock.lock();
        try {
            System.out.println("El tren ha finalizado el viaje.");
            puedeViajar = false; // Resetea la bandera
            puedenSubir = false; //restea bandera
        } finally {
            lock.unlock(); // Libera el lock
        }
    }
}
