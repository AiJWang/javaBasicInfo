package ForkJoinStudy;

import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * 计算0-1000000000L 累加的和
 * */
public class ForkJoinTest {
    public static void main(String[] args) {
        test2();
    }
    //这是1.8之前用forkjoin
    public static void forkTest(){
        //forkjoin使用 比for循环快，当数据量比较大的时候
        ForkJoinPool p=new ForkJoinPool();
        ForkJoinStudy forkJoinStudy=new ForkJoinStudy(0,1000000000L);
        long sum=p.invoke(forkJoinStudy);
        System.out.println(sum);
    }
    //1.8后使用,并行流
    public static void test2(){
        OptionalLong sum=LongStream.rangeClosed(0,1000000000L)
                .parallel()  //并行流
                .reduce(Long::sum);
        if (sum.isPresent())
            System.out.println(sum.getAsLong());
    }
}
