public class Test {
    public static void main(String[] args) {
        MontaniaRusa montañaRusa = new MontaniaRusa();
        for (int i = 1; i <= 20; i++) {
            Visitante v = new Visitante(i, montañaRusa);
            v.start();
            try {
                Thread.sleep(500); // llegan escalonados
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
