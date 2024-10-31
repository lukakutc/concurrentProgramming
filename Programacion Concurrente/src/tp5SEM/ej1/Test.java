package tp5SEM.ej1;

public class Test {
    public static void main(String[] args) {
        int i;
        GestorPiscina p = new GestorPiscina();
        
        Thread [] arreglo = new Thread[150];

        for(i=0;i<150;i++){
            arreglo[i] = new Thread(new Persona(p), "#"+(i+1));    
        }
        for(i=0;i<150;i++){
            arreglo[i].start();
        }
    
    }
}
