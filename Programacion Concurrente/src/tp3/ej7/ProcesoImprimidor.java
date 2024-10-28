package tp3.ej7;

public class ProcesoImprimidor implements Runnable {
    private String letra;
    private int cantVecesAImp;
    private int miTurno;
    private Turno turno; // variable compartida

    public ProcesoImprimidor(String letra, int cantVeces, int miTurno, Turno turno) {
        this.letra = letra;
        this.cantVecesAImp = cantVeces;
        this.miTurno = miTurno;
        this.turno = turno;
    }

    public void run() {
        int i, j = 0;
        while (j < 25) {
            if (miTurno == turno.getTurno()) {
                for (i = 0; i < cantVecesAImp; i++) {
                    System.out.print(letra);
                }
                // esto se soluciona con un mod
                if (turno.getTurno() == 0) {
                    turno.cambiar(1);
                } else if (turno.getTurno() == 1) {
                    turno.cambiar(2);
                } else if (turno.getTurno() == 2) {
                    turno.cambiar(0);
                }

            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }

    }
}