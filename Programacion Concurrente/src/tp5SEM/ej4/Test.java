package tp5SEM.ej4;

public class Test {
    public static void main(String[] args) {
        int i;
        Thread[] arreglo = new Thread[100];
        Comedor c = new Comedor(3,11);
        for (i=0;i<100;i++){
            if((i+1)%2==0){
                arreglo[i] = new Thread(new Animal("Gato",c,(i+1)));
            }else{
                arreglo[i] = new Thread(new Animal("Perro",c,(i+1)));
            }
        }

        for(i=0;i<100;i++){
            arreglo[i].start();
        }
    
    }
}
