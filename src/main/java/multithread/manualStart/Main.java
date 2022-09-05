package multithread.manualStart;

public class Main {
    public int x =0;
    public static void main(String[] args) {
        System.out.println("single"+Thread.currentThread().toString());
        for(int i = 0; i < 100; i++){
            Thread t = new Thread(new PrintInNewThread(i));
            t.start();
        }
    }
}
