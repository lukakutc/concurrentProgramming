package tp8.ejParcialPelicula;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Filmacion {
    //Recurso compartido
    private int capsOriginal;
    private int capsTraducidos;
    private ArrayList<int> capsEsp;
    private Lock lock = new ReentrantLock();
    private Condition capSinTraducir = lock.newCondition();
    private Condition capsDisponiblesEs = lock.newCondition();
    private Condition capsDisponiblesTr = lock.newCondition();
    
    public Filmacion() {
        capsOriginal =0;
        capsTraducidos = 0;
    }

    public void producirCapitulo(){
        System.out.println("Se produjo capitulo en espaniol");
    }
    
    
}
