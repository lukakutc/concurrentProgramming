package tp5SEM.ej8;

public class Test {
    public static void main(String[] args) {
        int i;
        Cuerda cuerda = new Cuerda();
        Thread [] arreglo = new Thread[150];
        for(i=0;i<150;i++){
            if(i%2 == 0){
                arreglo[i] = new Thread(new Babuino(cuerda,"I"),""+i);
            }else{
                arreglo[i] = new Thread(new Babuino(cuerda,"D"),""+i);
            }            
        }

        for(i=0;i<150;i++){
            arreglo[i].start();
        }
    }
}