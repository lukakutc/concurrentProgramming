package ejerciciosClasicos.probando1;

public class hilo3 extends Thread{
    //Al ser una clase le podemos poner atributos aunq ni idea si es la idea eso o trabajar con CurrenThread.name
    public void run(){
        int i;
        for(i=0;i<100;i++){
            System.out.println("Mostrando i: "+i+" En hilo 3");
        }
    }
}
