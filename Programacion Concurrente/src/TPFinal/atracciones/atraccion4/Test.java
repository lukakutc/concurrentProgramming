package TPFinal.atracciones.atraccion4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {


        System.out.println("Probando, muy probablemente se rmopa todo");
        ControlTren ct = new ControlTren(10);
        int i;

        new Thread(new Tren(ct)).start();
        for(i=0;i<50;i++){
            new Thread(new Visitante(ct)).start();
        }
    }
}
