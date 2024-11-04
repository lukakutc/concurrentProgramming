package tp5SEM.ej4;

import java.util.concurrent.Semaphore;

public class Comedor {
    // Recurso comparido
    // puede ser un contador ejemplo 15 y 15 y cambiar el turno
    // y hacer release de 15 de la otra especie
    private int comieron;
    private String tipoActual;
    private Semaphore semGatos;
    private Semaphore semPerros;
    private Semaphore comedero;
    private int cantAnimalesPorTurno;

    public Comedor(int cantComederos,int cantAnimalesPorTurno) {
        comieron = -1;
        semGatos = new Semaphore(0);
        semPerros = new Semaphore(0);
        comedero = new Semaphore(cantComederos);
        this.cantAnimalesPorTurno = cantAnimalesPorTurno;
    }

    public void comer(Animal animal) {
        if (comieron == -1) { // Si todavia nadie comió
            if (animal.getTipo().equals("Gato")) {
                comieron = 0;
                semGatos.release(cantAnimalesPorTurno);
                tipoActual = "Gato";
            } else {
                comieron = 0;
                semPerros.release(cantAnimalesPorTurno);
                tipoActual = "Perro";
            }
        }
        if (animal.getTipo().equals("Gato")) {
            try {
                semGatos.acquire();
                comedero.acquire();
                System.out.println("Gato "+animal.getNumero()+" comiendo! miau miau");
                Thread.sleep((int) (Math.random() * 500));
                comieron++;
                comedero.release();
            } catch (InterruptedException e) {
            }
        }else{
            try {
                semPerros.acquire();
                comedero.acquire(2);
                System.out.println("Perro "+animal.getNumero()+" comiendo! guau guau");
                Thread.sleep((int) (Math.random() * 500));
                comieron++;
                comedero.release(2);
            } catch (InterruptedException e) {
            }
        }
        if(comieron==cantAnimalesPorTurno){
            comieron=0;
            if(tipoActual.equals("Gato")){
                
                semPerros.release(cantAnimalesPorTurno);
                tipoActual = "Perro";
            }else{
                
                semGatos.release(cantAnimalesPorTurno);
                tipoActual = "Gato";
            }
        }

    }
}

// Lo hacemos con caso inicial y despues intentamos sin
