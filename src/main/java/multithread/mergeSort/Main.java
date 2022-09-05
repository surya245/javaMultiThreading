package multithread.mergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> array = List.of(4,3,5,1,9);

        System.out.println(array.toString());
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Future<List<Integer>> sortedArrFuture = executor.submit(new MergeSort(array));

        MergeSort sorter = new MergeSort(array);
        array = sorter.call();
//        array = sortedArrFuture.get();
        System.out.println(array.toString());
    }
}
