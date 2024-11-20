package recuLocksMon.hamsters.platoYRueda;

public class Rueda {
    //Recurso compartido
    private int capacidad;
    private int corriendo;
    // En este caso, en la rueda solo tiene que haber un hamster
    //Esto es como poner capacidad/corriendo 1 y que se reduzca cuando alguien entre
    //y se aumente cuando alguien sale
    //Pero como la capacidad es uno, solo con tener el syncrhonized basta!!
    //O sea el syncrhonized ya controla ese comportamiento. cuando tenemos
    //Variables mayor a uno es cuando lo necesitamos
    public Rueda(int capacidad){
        this.capacidad = capacidad;
    }

    public synchronized void empezarCorrer(String elNombre){
        while(corriendo>=capacidad){
            System.out.println(elNombre+" debe esperar para usar la rueda");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(elNombre+ " empieza a usar la rueda");
        corriendo++;
    }

    public synchronized void terminarCorrer(String elNombre){
        System.out.println(elNombre+" Termino de usar la rueda");
        corriendo--;
        this.notify();
    }
}
