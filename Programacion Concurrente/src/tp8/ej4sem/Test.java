package tp8.ej4sem;

public class Test {
    public static void main(String[] args) {
        Thread[] arreglo = new Thread[50];
        Centro centro = new Centro();
        int i;
        for(i=0;i<50;i++){
            arreglo[i]= new Thread(new Persona(centro),""+i);
        }
        for(i=0;i<50;i++){
            arreglo[i].start();
        }
    }
}
