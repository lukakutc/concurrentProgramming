package tp3.ej7;

public class Test {
    public static void main(String[] args) {
        //Creo recurso compartido turno
        Turno turno = new Turno();

        Thread h1 = new Thread(new ProcesoImprimidor("a", 3,0, turno));
        Thread h2 = new Thread(new ProcesoImprimidor("b",5 , 1, turno));
        Thread h3 = new Thread(new ProcesoImprimidor("c",4 , 2, turno));

        h1.start();
        h2.start();
        h3.start();
    }
}
