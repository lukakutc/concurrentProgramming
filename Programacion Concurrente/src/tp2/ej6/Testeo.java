package tp2.ej6;

public class Testeo {
    public static void main(String[] args) {
        System.out.println("Bienvenido a la carrera. Hoy correran los corredores del 1 al 10");
        //Creo objeto compartido meta
        Meta meta = new Meta(10);
        //Creo arreglo de corredores
        Thread[] arreglo = new Thread [10];
        int i;
        for(i=0;i<=9;i++){
            arreglo[i] = new Thread(new Corredor("Corredor "+(i+1),meta));
        }
        //Inicio
        for(i=0;i<10;i++){
            arreglo[i].start();
        }

    }
}
