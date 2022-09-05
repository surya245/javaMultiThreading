package multithread.manualStart;

public class PrintInNewThread implements Runnable{
    int num;

    public PrintInNewThread(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println(this.num + Thread.currentThread().toString());
    }
}
