package tp4.Ej4;

import java.util.concurrent.Semaphore;

public class GestorImpresora {
    //Recurso compartido. 
    //seran 3 impresoras.

    //Orden de ejecución:
    //Cliente -> imprime: si hay libres imprime
    //              sino espera
    //Si tenemos 3 fkn impresoras, como
    //hacemos sin semaforo generico?

    //Voy a intenar con variable
    Semaphore imprime = new Semaphore(1);
    Semaphore imp1 = new Semaphore(1);
    Semaphore imp2 = new Semaphore(1);
    Semaphore imp3 = new Semaphore(1);
    int impresorasDisponibles = 1;
    public GestorImpresora(){};

    public void imprimir(){
        if(impresorasDisponibles == 0){
            try {
                imprime.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{

        }
    }





}

