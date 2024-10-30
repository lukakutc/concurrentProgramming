package ejerciciosClasicos.BarberoDormilon;

import java.util.concurrent.Semaphore;

public class Sillon {
    private Semaphore barbero;
    private Semaphore sillon;
    private Semaphore salida;

    public Sillon(){
        barbero = new Semaphore(0);
        sillon = new Semaphore(1);
    }
    //creo que debemos identificar nosotros
    //Como se va a comportar el programa
    //Primero: barbero durmiendo y sillon vacio
    //segundo: sillon ocupado y barbero durmiendo
    //Tercero: sillon ocupado y barbero despierto
    //Cuarto: sillon ocupado y barbero termina corte
    //quinto: sillon liberado
    //sexto: barbero durmiendo y sillon vacio

    public void sentarseSillon(){
        //1
        try {
            sillon.acquire();
        } catch (InterruptedException e) {
        }
    }
    public void terminarCortar(){
        //4
        sillon.release();
    }
    public void avisarBarbero(){
        //2
        barbero.release();
    }
    public void cortar(){
        //3
        try {
            barbero.acquire();
        } catch (InterruptedException e) {
        }
    }
}
