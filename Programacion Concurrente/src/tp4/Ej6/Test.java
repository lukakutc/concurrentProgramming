package tp4.Ej6;

public class Test {
    public static void main(String[] args) {
        Taxi t = new Taxi();

        Thread taxista = new Thread(new Taxista(t));
        Thread pasajero = new Thread(new Pasajero(t));

        taxista.start();
        pasajero.start();
    }
}
