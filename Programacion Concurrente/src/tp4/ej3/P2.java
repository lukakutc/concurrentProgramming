package tp4.ej3;

public class P2 implements Runnable {
    private HiloControlador h;

    public P2(HiloControlador h) {
        this.h = h;
    }

    public void run() {
        while (true) {
            h.adquirirP2();
            System.out.println("Ejecuntado P2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            h.liberarP1();
        }

    }
}
