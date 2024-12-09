package TPFinal.atracciones.atraccion4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {


        ScheduledExecutorService temporizador = Executors.newSingleThreadScheduledExecutor();
        
        System.out.println("Esperando los 5 segundos");
        temporizador.schedule(new HiloTest(), 5, TimeUnit.SECONDS);
        temporizador.shutdown();
        System.out.println("despues o antes de los 5 segundos?");
    }
}
