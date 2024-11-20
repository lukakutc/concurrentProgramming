package recuLocksMon.locks.tp7ej1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GestorSala {
    // Recurso compartido
    Lock lock = new ReentrantLock();
    Condition puedeEntrar = lock.newCondition();
    Condition puedeEntrarJubilado = lock.newCondition();
    private int temperatura;
    private int tUmbral;
    private int capacidad;
    private int capacidadReducida;
    private int dentro;
    private int jubiladosEsperando;

    public GestorSala(int temperatura, int tUmbral, int capacidad, int capacidadReducida) {
        this.temperatura = temperatura;
        this.tUmbral = tUmbral;
        this.capacidad = capacidad;
        this.capacidadReducida = capacidadReducida;
        this.dentro = 0;
        this.jubiladosEsperando = 0;
    }

    public void entrarSala(String nombre) {
        lock.lock();
        try {
            while (dentro >= capacidad || jubiladosEsperando > 0) {
                System.out.println(nombre + " debe esperar para entrar");
                puedeEntrar.await();
            }
            dentro++;
            System.out.println(nombre + " entra a la sala");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }

    }

    public void salirSala(String nombre) {
        lock.lock();
        try {
            System.out.println(nombre + " sale de sala");
            dentro--;
            puedeEntrar.signal();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }

    }

    public void entrarSalaJubilado(String nombre) {
        lock.lock();
        jubiladosEsperando++; // Mientras espera hay jubilados esperando
        try {
            while (dentro >= capacidad) {

                System.out.println(nombre + " debe esperar para entrar");
                puedeEntrar.await();

            }
            jubiladosEsperando--;
            puedeEntrar.signalAll();//Como hay un jubilado menos en espera signal
            dentro++;
            System.out.println(nombre + " entra a la sala");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void salirSalaJubilado(String nombre) {
        lock.lock();
        try {
            System.out.println(nombre + " sale de sala");
            dentro--;
            puedeEntrar.signalAll();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }
}
