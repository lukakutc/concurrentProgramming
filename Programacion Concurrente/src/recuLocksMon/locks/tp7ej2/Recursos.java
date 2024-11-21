package recuLocksMon.locks.tp7ej2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Recursos {
    //Recurso compartido
    Lock lock = new ReentrantLock();
    Condition puedeProgramar = lock.newCondition();
    private int compuTotal;
    private int compuUsadas;
    private int librosTotal;
    private int librosUsados;

    

    public Recursos(int compuTotal, int librosTotal) {
        this.compuTotal = compuTotal;
        this.librosTotal = librosTotal;
        compuUsadas=0;
        librosUsados=0;
    }

    public void empezarProgramar(String nombre){
        try {
            lock.lock();
            while(compuUsadas>=compuTotal || librosUsados>=librosTotal){
                System.out.println(nombre+ " debe esperar para programar");
                puedeProgramar.await();
            }
            compuUsadas++;
            librosUsados++;
            System.out.println(nombre+" empieza a programar");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void terminarProgramar(String nombre){
        try {
            lock.lock();
            System.out.println(nombre+" deja de programar");
            compuUsadas--;
            librosUsados--;
            puedeProgramar.signal();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }
}
