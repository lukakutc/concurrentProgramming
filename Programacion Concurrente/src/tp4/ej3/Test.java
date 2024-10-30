package tp4.ej3;

public class Test {
    public static void main(String[] args) {
        HiloControlador h = new HiloControlador();

        Thread h1 = new Thread(new P1(h));
        Thread h2 = new Thread(new P2(h));
        Thread h3 = new Thread(new P3(h));

        h1.start();
        h2.start();
        h3.start();
    }
}
