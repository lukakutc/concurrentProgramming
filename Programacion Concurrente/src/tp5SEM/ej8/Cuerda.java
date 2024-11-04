package tp5SEM.ej8;

import java.util.concurrent.Semaphore;

public class Cuerda {
    // Recurso compartido cuerda
    String turno;
    private Semaphore cuerda;
    private Semaphore ladoIzquierdo;
    private Semaphore ladoDerecho;
    private int cruzaron;
    private Semaphore mutex;

    public Cuerda() {
        cuerda = new Semaphore(5);
        ladoIzquierdo = new Semaphore(15);
        ladoDerecho = new Semaphore(0);
        turno = "I";
        mutex = new Semaphore(1);
    }

    public void cruzar(String tipo) {
        if (tipo.equals("I")) {
            try {
                ladoIzquierdo.acquire();
                cuerda.acquire();
                System.out.println(
                        "Babuino " + Thread.currentThread().getName() + " cruzando de lado izquierdo a derecho");
                Thread.sleep(3000);
                System.out.println("Babuino " + Thread.currentThread().getName()
                        + " termino de cruzar de lado izquierdo a derecho");
                mutex.acquire();
                cruzaron++;

                if (cruzaron % 5 == 0) {
                    mutex.release();
                    cuerda.release(5);
                } else {
                    mutex.release();
                }

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                ladoDerecho.acquire();
                cuerda.acquire();
                System.out.println(
                        "Babuino " + Thread.currentThread().getName() + " cruzando de lado derecho a izquierdo");
                Thread.sleep(3000);
                System.out.println("Babuino " + Thread.currentThread().getName()
                        + " termino de cruzar de lado derecho a izquierdo");
                mutex.acquire();
                cruzaron++;
                if (cruzaron % 5 == 0) {
                    mutex.release();
                    cuerda.release(5);
                } else {
                    mutex.release();
                }

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        try {
            mutex.acquire();
            if (cruzaron == 15) {
                cambiarTurno();
            }
            mutex.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void cambiarTurno() {
        cruzaron = 0;
        if (turno.equals("I")) {
            turno = "D";
            ladoDerecho.release(15);
        } else {
            turno = "I";
            ladoIzquierdo.release(15);
        }
    }

}
