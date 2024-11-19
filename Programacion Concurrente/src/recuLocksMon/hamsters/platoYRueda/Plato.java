package recuLocksMon.hamsters.platoYRueda;

public class Plato {
    //Recurso compartido monitor
    private int capacidad;
    private int comiendo;

    public Plato(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public synchronized void empezarComer(String elNombre){
        while(comiendo>=capacidad){
            try {
                System.out.println("El hamster "+elNombre+" debe esperar para comer");
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("El hamster "+elNombre+" empezó a comer");
        comiendo++;
    }

    public synchronized void terminarComer(String elNombre){
        System.out.println("El hamster "+elNombre+" termino de comer");
        comiendo--;
        this.notify(); //cuando se modifica la condicion
        //Que puede hacer que otros entren es cuando va el notify
    }
    
}
