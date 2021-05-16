package myNameThreadModel;

public class MainThread {
    public static void main(String[] args){
        String[] lista = new String[]{"M","I","G","U","E","L"};

        for (String letra : lista){
            Thread th = new ThreadModel(letra);
            th.start();
        }
    }
}
