package tp4.ej3;

public class P1 implements Runnable {
    private HiloControlador h;

    public P1(HiloControlador h) {
        this.h = h;
    }

    public void run() {

        while (true) {
            h.adquirirP1();
            System.out.println("Ejecuntado P1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            h.liberarP3();
        }

    }
}
