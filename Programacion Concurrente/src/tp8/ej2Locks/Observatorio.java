package tp8.ej2Locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Observatorio {
    private int capacidad;
    private int capacidadConSilla;
    private int capacidadActual;
    private int personasDentro;
    private int investigadorDentro;
    private int mantenimientoDentro;
    private Lock lock = new ReentrantLock();
    private Condition puedeVisitante= lock.newCondition();
    private Condition puedeVisitanteSilla = lock.newCondition();
    private Condition puedeMantenimiento= lock.newCondition();
    private Condition puedeInvestigador = lock.newCondition();
    private int sillaEsperando;
    
    
    public Observatorio(int capacidad, int capacidadConSilla) {
        this.capacidad = capacidad;
        this.capacidadActual = capacidad;
        this.capacidadConSilla = capacidadConSilla;
        personasDentro = 0;
        investigadorDentro =0;
        mantenimientoDentro = 0;
        sillaEsperando = 0;
    }

    public void entrarSilla(String nombre){
        lock.lock();
        sillaEsperando++;
        try {
            while(personasDentro>=capacidadConSilla || mantenimientoDentro>0 || investigadorDentro>0 ){
                System.out.println(nombre+" debe esperar para entrar");
                puedeVisitanteSilla.await();
            }
            sillaEsperando--;
            personasDentro++;
            capacidadActual = capacidadConSilla;
            System.out.println(nombre+" entro a la sala.");
            System.out.println("La capacidad redujo de "+capacidad+" a "+capacidadConSilla );
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }
    public void salirSilla(String nombre){
        lock.lock();
        personasDentro--;
        System.out.println("Sale "+nombre+" de la sala");
        System.out.println("Capacidad pasa de: "+capacidadConSilla+" a "+capacidad);
        capacidadActual = capacidad;
        puedeVisitanteSilla.signalAll();
        puedeVisitante.signalAll();
        puedeInvestigador.signalAll();
        puedeMantenimiento.signalAll();
        lock.unlock();
    }
    public void entrarPersona(String nombre){
        lock.lock();
        try {
            while(sillaEsperando>0||personasDentro>=capacidadActual||mantenimientoDentro>0||investigadorDentro>0){
                System.out.println(nombre+" debe esperar");
                puedeVisitante.await();
            }
            personasDentro++;
            System.out.println(nombre+" entro a la sala");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }
    public void salirPersona(String nombre){
        lock.lock();
        System.out.println(nombre+"sale de la sala");
        personasDentro--;
        puedeVisitanteSilla.signalAll();
        puedeVisitante.signalAll();
        puedeInvestigador.signalAll();
        puedeMantenimiento.signalAll();
        lock.unlock();
    }

    public void entrarMantenimiento(String nombre){
        lock.lock();
        try {
            while(personasDentro>0||investigadorDentro>0||mantenimientoDentro>=capacidadActual){
                System.out.println(nombre+" debe esperar para entrar");
                puedeMantenimiento.await();
            }
            mantenimientoDentro++;
            System.out.println(nombre+"Entro a la sala");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }
    public void salirMantenimiento(String nombre){
        lock.lock();
        mantenimientoDentro--;
        System.out.println(nombre+"sale de la sala");
        puedeMantenimiento.signalAll();
        puedeInvestigador.signalAll();
        puedeVisitanteSilla.signalAll();
        puedeVisitante.signalAll();
        lock.unlock();
    }

    public void entrarInvestigador(String nombre){
        lock.lock();
        try {
            while(investigadorDentro>=capacidadActual||personasDentro>0||mantenimientoDentro>0){
                System.out.println(nombre+" debe esperar para entrar");
                puedeInvestigador.await();
            }
            investigadorDentro++;
            System.out.println(nombre+"Ha entrado a la sala");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{

        }lock.unlock();
    }
    public void salirInvestigador(String nombre){
        lock.lock();
        investigadorDentro--;
        System.out.println(nombre+"sale de la sala");
        puedeInvestigador.signalAll();
        puedeMantenimiento.signalAll();
        puedeVisitante.signalAll();
        puedeVisitanteSilla.signalAll();
        lock.unlock();
    }
}
