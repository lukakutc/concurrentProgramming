package tp8.ejParcialAgua;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Recipiente {
    //recurso compartido
    int hidrogeno;
    int oxigeno;
    Lock lock = new ReentrantLock();
    Condition hayOxigeno = lock.newCondition();
    Condition hayHidrogeno = lock.newCondition();
    int agua;
    int capacidad;

    

    public Recipiente() {
        hidrogeno = 0;
        oxigeno = 0;
        agua = 0;
        capacidad = 10;
    }
    public void Olisto(){
        try {
            lock.lock();
            oxigeno++;
            hayOxigeno.signal();
            while(hidrogeno<2){
                System.out.println("El atomo de oxigeno debe esperar por 2 de hidrogeno");
                hayHidrogeno.await();
            }
            System.out.println("Atomos juntados, haciendo agua");
            hidrogeno = hidrogeno -2;
            oxigeno--;
            hacerAgua();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }
    public void Hlisto(){
        try {
            lock.lock();
            hidrogeno++;
            hayHidrogeno.signal();
            while(oxigeno<=0||hidrogeno<2){
                if(oxigeno<=0){
                    System.out.println("El atomo de hidrogeno debe esperar por uno de oxigeno");
                    hayOxigeno.await();
                }else{
                    System.out.println("los atomos de oxigeno e hidrogeno necesitan uno mas de hidrogeno");
                    hayHidrogeno.await();
                }
            }
            System.out.println("atomos juntados, haciendo agua");
            hidrogeno = hidrogeno - 2;
            oxigeno--;
            hacerAgua();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void hacerAgua(){
        lock.lock();
        System.out.println("Agua hecha ");
        agua++;
        if(agua==capacidad){
            System.out.println("Recipiente vaciado");
            agua=0;
        }
        lock.unlock();
    }

}
