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

        ForkJoinPool assignedPools = new ForkJoinPool(3);   // Thread 갯수 할당

        assignedPools.submit(() -> // 할당받은 Thread 로 작업 배정
            IntStream.range(0, 100).parallel().forEach(index ->{    // index가 0~99까지 있는데 이게 3개의 쓰레드에 할당되어 작업 진행ㄴ
            System.out.println("Selected thread name : "+ Thread.currentThread().getName()+ ", index :" +index+ ", result :"+sum(index));
            try {
                Thread.sleep(1000);
            }catch (Exception e){
            }
            })
        ).get();
    }
}
