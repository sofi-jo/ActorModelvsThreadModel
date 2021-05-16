package myNameThreadModel;

public class ThreadModel extends Thread {

    private String message;
    public ThreadModel(String letra){
        this.message = letra;
    }
    @Override
    public void run() {
        System.out.println(message);
    }

}
