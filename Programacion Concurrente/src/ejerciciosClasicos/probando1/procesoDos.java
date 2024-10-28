package ejerciciosClasicos.probando1;

public class procesoDos implements Runnable{
    public void run(){
        int i;
        for (i=0;i<100;i++){
            System.out.println("Mostrando i: "+i+" proceso dos");
        }
    }
}
