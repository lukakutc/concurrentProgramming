package tp8.ej1tp7sabado;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GestorSala {
    //Recurso compartido
    Lock lock = new ReentrantLock(true);
    private Condition entraPersona = lock.newCondition();
    private Condition entraJubilado = lock.newCondition();
    private int dentro;
    private int capacidadNormal;
    private int capacidadReducida;
    private int capacidadActual;
    private int jubiladosEsperando;
    private int tUmbral;
    

    public GestorSala(int capacidadNormal, int capacidadReducida, int tUmbral){
        this.capacidadNormal = capacidadNormal;
        this.capacidadActual = capacidadNormal;
        this.capacidadReducida = capacidadReducida;
        this.tUmbral = tUmbral;
        dentro=0;
        jubiladosEsperando = 0;
        }
    public void entrarSala(String nombre){
        try {
            lock.lock();
            while(dentro>=capacidadActual || jubiladosEsperando>0){
                System.out.println(nombre+" debe esperar para entrar");
                entraPersona.await();
            }
            dentro++;
            System.out.println(nombre+" entro a la sala");
        } catch (Exception e) {
        }finally{
            lock.unlock();
        }
    }
    public void entrarSalaJubilado(String nombre){
        try {
            lock.lock();
            jubiladosEsperando++;
            while(dentro>=capacidadActual){
                System.out.println(nombre+" debe esperar para entrar");
                entraJubilado.await();
            }
            jubiladosEsperando--;
            dentro++;
            System.out.println(nombre+" entro a la sala");
        } catch (Exception e) {
        }finally{
            lock.unlock();
        }
    }

    public void salirSala(String nombre){
        //Con un mismo metodo pueden salir jubilados y personas porque lo unico
        //Que hace es modificar la variable dentro
        try {
            lock.lock();
            dentro--;
            System.out.println(nombre+ " sale de la sala");
            if(jubiladosEsperando>0){
                entraJubilado.signal();
            }else{
                entraPersona.signal();
            }
        } catch (Exception e) {
        }finally{
            lock.unlock();
        }
    }

    public void notificarTemperatura(int temperatura){
        if(temperatura>tUmbral){
            System.out.println("La capacidad bajo de "+capacidadActual+" a "+capacidadReducida);
            capacidadActual = capacidadReducida;
        }else{
            System.out.println("La capacidad cambio de "+capacidadActual+" a "+capacidadNormal);
            capacidadActual = capacidadNormal;
        }
    }

}
