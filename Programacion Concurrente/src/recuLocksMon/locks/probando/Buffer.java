package recuLocksMon.locks.probando;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    ReentrantLock lock = new ReentrantLock(true);
    Condition noVacio = lock.newCondition();
    Condition noLleno = lock.newCondition();
    private int cabecera;
    int[] cola;

    public Buffer(int capacidad) {
        cola = new int[capacidad];
        cabecera = capacidad;
    }

    public void poner(int numero) {
        lock.lock();
        while (cabecera == 0) {
            try {
                // si la cola esta esta llena hay que esperar a que no este llena
                noLleno.await();
            } catch (InterruptedException e) {
            }
        }
        // Si la cola no esta llena podemos poner
        cola[cabecera] = numero;
        cabecera--;
        //Avisamos que ya no esta vacio
        noVacio.signal();
        lock.unlock();
    }
    public void sacar(int numero){
        lock.lock();
        while(cabecera==20){
            //Si la cola aesta vacia hay que esperar a que no lo este
            try {
                noVacio.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //Si no esta vacia podemos sacar
    }

    
}