package recuLocksMon.locks.ej1melopasaron.ejer1;
import java.util.concurrent.locks.*;

public class GestorSala {
    private Lock mutex;
    private Condition condicionPersona;
    private Condition condicionJubilado;
    private int umbral = 30;
    private int cantPersonasSala = 0;
    private int capacidadSala = 5;
    private int cantidadJubilados = 0;

    public GestorSala(){
        mutex = new ReentrantLock();
        condicionJubilado = mutex.newCondition();
        condicionPersona = mutex.newCondition();
    }
    
    public boolean hayDisponibilidadEnLaSala(){
        return this.cantPersonasSala < capacidadSala;
    }

    public void entrarSala(){
        mutex.lock();
        try {
            /* Si hay algun jubilado esperando o no hay lugar, se mantiene en el await() */
            while (!hayDisponibilidadEnLaSala() || cantidadJubilados > 0) {
                condicionPersona.await();
            }

            /* Entra una persona porque no hay jubiulados esperando y hay disponibilidad! */
            cantPersonasSala++;
            System.out.println("La persona " + Thread.currentThread().getName() + " ha entrado a la sala!");

        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            mutex.unlock();
        }
    }

    public void entrarSalaJubilado(){
        mutex.lock();
        cantidadJubilados++;
        try {
            while (!hayDisponibilidadEnLaSala()) {
                condicionJubilado.await();
            }

            /* Logra entrar un jubilado a la sala */
            cantPersonasSala++;
            cantidadJubilados--;
            System.out.println("Entro el " + Thread.currentThread().getName() + " a la sala!");

        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            mutex.unlock();
        }
    }

    public void salirSala(){
        mutex.lock();
        try {
            /* el ojubilado o la persona deja la sala */
            cantPersonasSala--;
            System.out.println("Salio el/la " + Thread.currentThread().getName() + " de la sala!");
            // System.out.println(cantPersonasSala);
            condicionJubilado.signalAll();
            condicionPersona.signal();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            mutex.unlock();
        }
    }

    public void notificarTemperatura(int temperatura){
        mutex.lock();
        this.umbral += temperatura;
        if (umbral >= 35){
            System.out.println("La temperatura ha aumentado a 35°, ahora solo podran ingresar hasta 3 personas");
            capacidadSala = 3;
        }else{
            System.out.println("La temperatura se mantiene bajo los 35°, se mantiene la capacidad en 5 personas");
            capacidadSala = 5;
        }
        mutex.unlock();
    }

}
