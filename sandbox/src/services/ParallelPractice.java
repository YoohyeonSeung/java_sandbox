package services;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelPractice {

    public int sum(int n){
        int result = 0;
        for(int i = n ; i<10000; i++)
            result += i;

        return result;
    }


    public void testParallel() throws ExecutionException, InterruptedException {

        ForkJoinPool assignedPools = new ForkJoinPool(3);

        assignedPools.submit(() ->
            IntStream.range(0, 100).parallel().forEach(index ->{
            System.out.println("Selected thread name : "+ Thread.currentThread().getName()+ ", index :" +index+ ", result :"+sum(index));
            try {
                Thread.sleep(1000);
            }catch (Exception e){
            }
            })
        ).get();
    }
}
