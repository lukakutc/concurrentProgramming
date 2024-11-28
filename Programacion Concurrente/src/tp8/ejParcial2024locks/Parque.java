package tp8.ejParcial2024locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parque {
    // Recurso compartido
    Lock lock = new ReentrantLock(true);
    Condition entraResidente = lock.newCondition();
    Condition entraNoResidente = lock.newCondition();
    Condition entraEscuela = lock.newCondition();
    Condition saleEscuela = lock.newCondition();
    private int dentro;
    private int capacidadNormal;
    private int capacidadReducidad;
    private int capacidadActual;
    private int residentesEsperando;
    private int escuelaEsperando;
    private int ninosDentro;
    private boolean ninosSaliendo;

    public Parque(int capacidadNormal, int capacidadReducidad) {
        this.capacidadNormal = capacidadNormal;
        this.capacidadReducidad = capacidadReducidad;
        dentro = 0;
        capacidadActual = capacidadNormal;
        residentesEsperando = 0;
        escuelaEsperando = 0;
        ninosDentro = 0;
        ninosSaliendo = false;
    }

    public void entraEscolar(int cantAlumnos, String nombre) {
        try {
            lock.lock();
            while (dentro + cantAlumnos >= capacidadActual) {
                System.out.println(nombre + " debe esperar para entrar");
                entraEscuela.await();
            }
            ninosDentro++;
            dentro++;
            System.out.println(nombre + " entro al parque");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void salirEscolar(int cantAlumnos, String nombre) {
        try {
            lock.lock();
            if (ninosDentro == cantAlumnos) { // El ultimo alumno cambia la condicion
                ninosSaliendo = true;
                saleEscuela.signalAll();
            }
            while (ninosDentro < cantAlumnos || !ninosSaliendo) {// debemos esperar a que todos los ninos quieran salir
                                                                 // para salir
                // (salen todos juntos)
                System.out.println(nombre + " debe esperar a todo el grupo para salir");
                saleEscuela.await(); 
            }
            dentro--;
            ninosDentro--;
            if(ninosDentro==0){
                //Si ya salieron todos los ninos
                System.out.println("Salio grupo escolar cambia la capacidad de "+capacidadActual+" a "+capacidadNormal);
                capacidadActual = capacidadNormal;
            }
            if(escolarEsperando>0){
                entraEscuela.signalAll();
            }else if(residentesEsperando>0){
                entraResidente.signal();
            }else{
                entraNoResidente.signal();
            }
            System.out.println(nombre+ " sale del parque");
            
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void entrarResidente(String nombre){
        try {
            lock.lock();
            residentesEsperando++;
            while(escolarEsperando>0 || dentro >= capacidadActual){
                System.out.println(nombre+" debe esperar para entrar");
                entraResidente.await();
            }
            dentro++;
            residentesEsperando--;
            System.out.println(nombre+" entra al parque");
            
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }
    public void salirResidente(String nombre){
        lock.lock();
        System.out.println(nombre+" sale del parque");
        dentro--;
        if(escolarEsperando>0){
            entraEscuela.signal();
        }else if(residentesEsperando>0){
            entraResidente.signal();
        }else{
            entraNoResidente.signal();
        }
        lock.unlock();
    }

    public void entrarNoResidente(String nombre){
        try {
            lock.lock();
            while(residentesEsperando>0 || escolarEsperando>0 || dentro>=capacidadActual){
                System.out.println(nombre+ " debe esperar para entrar");
                entraNoResidente.await();
            }
            dentro++;
            System.out.println(nombre+" entro al parque");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }
    public void salirNoResidene(String nombre){
        lock.lock();
        System.out.println(nombre+" sale del parque");
        dentro--;
        if(escolarEsperando>0){
            entraEscuela.signal();
        }else if(residentesEsperando>0){
            entraResidente.signal();
        }else{
            entraNoResidente.signal();
        }

        lock.unlock();
    }
}