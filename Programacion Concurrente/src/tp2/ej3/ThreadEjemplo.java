package tp2.ej3;

public class ThreadEjemplo extends Thread{
    public ThreadEjemplo(String str){
        super(str);
    }

    public void run(){
        int i;
        for(i=0;i<10;i++){
            System.out.println(i+" "+ getName());
        }
        System.out.println("Termina thread: "+getName());
    }
}