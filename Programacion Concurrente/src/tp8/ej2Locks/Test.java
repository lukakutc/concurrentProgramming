package tp8.ej2Locks;

public class Test {
    public static void main(String[] args) {
        Observatorio o = new Observatorio(5, 3);
        Thread[] a = new Thread[30];
        int i;

        for (i = 0; i < 30; i++) {
            if (i % 4 == 0) {
                a[i] = new Thread(new Persona(o, "p" + i));
                a[i].start();
            } else if (i % 4 == 1) {
                a[i] = new Thread(new PersonaSilla(o, "sr"+i));
                a[i].start();
            }else if(i%4 == 2){
                a[i] = new Thread(new Investigador("i"+i, o));
                a[i].start();
            }else{
                a[i] = new Thread(new Mantenimiento("m"+i, o));
                a[i].start();
            }
        }

    }
}
