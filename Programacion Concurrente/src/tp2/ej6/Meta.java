package tp2.ej6;

public class Meta {
    private int cantCorredores;
    private int distanciaMaxima;
    private String nombreCorredor;
    private int cantCorredoresIni;

    public Meta(int cantCorredores){
        this.cantCorredores = cantCorredores;
        this.cantCorredoresIni = cantCorredores;
    }

    public synchronized void terminoCarrera(int distanciaRecorrida, String nombreCorredor){
        if(distanciaMaxima < distanciaRecorrida){
            this.nombreCorredor = nombreCorredor;
            this.distanciaMaxima = distanciaRecorrida;
        }
        cantCorredores--;
        if(cantCorredores == 0){
            System.out.println("La carrera ha terminado.");
            System.out.println("Gano "+nombreCorredor+" con: "+distanciaMaxima+" metros recorridos");
        }
    }

}
