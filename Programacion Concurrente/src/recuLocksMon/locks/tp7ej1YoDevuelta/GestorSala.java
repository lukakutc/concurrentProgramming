package recuLocksMon.locks.tp7ej1YoDevuelta;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GestorSala {
    // Recurso compartido
    Lock lock = new ReentrantLock();
    Condition puedeEntrarJubilado = lock.newCondition();
    Condition puedeEntrar = lock.newCondition();
    private int capacidad;
    private int capacidadActual;
    private int capacidadReducida;
    private int jubiladosEsperando;
    private int dentroSala;
    private int tUmbral;
    private int tActual;

    public GestorSala(int capacidad, int capacidadReducida, int tUmbral, int tActual) {
        this.capacidad = capacidad;
        this.capacidadReducida = capacidadReducida;
        this.tUmbral = tUmbral;
        this.tActual = tActual;
        this.capacidadActual = capacidad;
    }

    public void entrarSala(String nombre) {
        try {
            lock.lock();
            while (dentroSala >= capacidadActual || jubiladosEsperando > 0) {
                System.out.println(nombre + " debe esperar para entrar");
                puedeEntrar.await();
            }
            dentroSala++;
            System.out.println(nombre + " entro a la sala");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void salirSala(String nombre) {
        try {
            lock.lock();
            System.out.println(nombre + " sale de la sala");
            dentroSala--;
            
            puedeEntrar.signalAll();
            puedeEntrarJubilado.signalAll();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }

    }

    public void entrarSalaJubilado(String nombre) {
        try {
            lock.lock();
            jubiladosEsperando++;
            while (dentroSala >= capacidadActual) {
                System.out.println("El jubilado " + nombre + " debe esperar para entrar");
                puedeEntrarJubilado.await();
            }
            dentroSala++;
            jubiladosEsperando--;
            System.out.println("El jubilado " + nombre + " entro a la sala");
            puedeEntrar.signalAll(); // Me parece que aca solo va signal de personas normales (xq se modifico

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void salirSalaJubilado(String nombre) {
        try {
            lock.lock();
            System.out.println("El jubilado " + nombre + " sale de la sala");
            dentroSala--;
            
            puedeEntrar.signalAll();
            puedeEntrarJubilado.signalAll();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void notificarTemperatura(int temperatura) {
        try {
            lock.lock();
            int capacidadAnterior = capacidadActual;
            tActual = temperatura;
            if (tActual > tUmbral) {
                capacidadActual = capacidadReducida;
                System.out.println("Se redujo la capacidad de "+capacidadAnterior+" a "+capacidadActual);
            } else {
                capacidadActual = capacidad;
                System.out.println("Cambio la capacidad de "+capacidadAnterior+" a "+capacidadActual);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }

    }
}
