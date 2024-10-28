package ejerciciosClasicos.probando1;

public class procesoUno implements Runnable {
    
    public void run(){
        //Este metodo lo tienen que tener todos los runnables y los hilos
        int i;
        for (i=0;i<100;i++){
            System.out.println("Mostrando i: "+i+ " pUno");
        }
    }
}
