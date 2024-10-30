package tp4.ej3;

public class P3 implements Runnable {
    private HiloControlador h;

    public P3(HiloControlador h) {
        this.h = h;
    }

    public void run() {
        while (true) {
            h.adquirirP3();
            System.out.println("Ejecutando P3");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            h.liberarP2();
        }
    }
}
