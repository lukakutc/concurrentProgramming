package tp4.Ej7;

public class Test {
    public static void main(String[] args) {
        
        Lugar l = new Lugar();

        Thread emp = new Thread(new Empleado(l));
        Thread mozo = new Thread(new Mozo(l));

        emp.start();
        mozo.start();
    }
}
