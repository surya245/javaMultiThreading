package multithread.mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MergeSort implements Callable<List<Integer>> {
    private List<Integer> arr;

    public MergeSort(List<Integer> arr) {
        this.arr = arr;
    }

    @Override
    public List<Integer> call() throws Exception{
        if(arr.size() < 2) return arr;

        int mid = arr.size()/2;
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        for(int i = 0; i < arr.size(); i++){
            if (i >= mid) {
                right.add(arr.get(i));
            } else {
                left.add(arr.get(i));
            }
        }

        //ExecutorService for future/callable.
        ExecutorService executor = Executors.newCachedThreadPool();
        // Future simply provides a bucket for the return type of callable, which will
        // store the value returned by the call function when the thread execution complete
        // below two lines are not in sync, but in parallel as the first one doesn't wait for
        // the second to complete
        Future<List<Integer>> sortedFutureLeft = executor.submit(new MergeSort(left));
        Future<List<Integer>> sortedFutureRight = executor.submit(new MergeSort(right));

        List<Integer> sortedLeft = sortedFutureLeft.get();
        List<Integer> sortedRight = sortedFutureRight.get();
        return mergeSorted(sortedLeft,sortedRight);
    }

    public List<Integer> mergeSorted(List<Integer> sortedLeft, List<Integer> sortedRight) {
        List<Integer> merged = new ArrayList();
        int i = 0;
        int j = 0;
        while(i < sortedLeft.size() && j < sortedRight.size()){
            if(sortedLeft.get(i) < sortedRight.get(j)) {
                merged.add(sortedLeft.get(i));
                i++;
            } else {
                merged.add(sortedRight.get(j));
                j++;
            }
        }
        while(i < sortedLeft.size()){
            merged.add(sortedLeft.get(i));
            i++;
        }
        while(j < sortedRight.size()){
            merged.add(sortedRight.get(j));
            j++;
        }
        return merged;
    }
}
