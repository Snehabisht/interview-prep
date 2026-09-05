package multithreading.exectorFramework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolImpl {
    static void main() {
        int arr[] = {1,2, 3, 4, 5, 6, 7, 8};
        ForkJoinPool pool = new ForkJoinPool();

        SumTask task = new SumTask(arr, 0, arr.length-1);

        int result = pool.invoke(task);

        System.out.println(result);

        pool.shutdown();
    }
}

class SumTask extends RecursiveTask<Integer> {

    private int[] arr;
    private int start;
    private int end;

    public SumTask(int arr[], int start, int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        // base condition
        if(end-start <=2) {
            return arr[start]+arr[end];
        }
        // fork
        int mid = (start + end)>>1;
        SumTask leftTask = new SumTask(arr, start, mid);
        SumTask rightTask = new SumTask(arr, mid+1, end);
        leftTask.fork(); // put in work stealing queue for now
        int sum2 = rightTask.compute(); // work on right for now
        int sum1 = leftTask.join(); // wait current thread till leftTask vala thread is completed

        // join
        return sum1+sum2;
    }
}
