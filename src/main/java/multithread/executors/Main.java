package multithread.executors;

import multithread.manualStart.PrintInNewThread;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        Executor executor = Executors.newCachedThreadPool();
        Executor executor = Executors.newSingleThreadExecutor();
        Executor fixedEx = Executors.newFixedThreadPool(10);
        for(int i = 0; i <= 100; i++) {
            if(i == 50){
                System.out.println("Pause");
            }
            fixedEx.execute(new PrintInNewThread(i));
        }
    }
}
