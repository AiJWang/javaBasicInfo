package ForkJoinStudy;

import java.util.concurrent.RecursiveTask;

/**
 * forkjoin 框架：执行程序时，将所有线程fork成一个个可执行的小任务，直至不可再拆分为止(设置的临界值)，执行每个小任务，然后join所有结果
 * 窃取模式：每个线程上若没有可执行的程序，偷取其他线程任务执行，提高cpu使用率
 * 必须 继承 RecursiveTask RecursiveAction，区别就是一个有返回值，一个没返回值
 * */
//本次是计算long数的累加的
public class ForkJoinStudy extends RecursiveTask<Long> {

    long start;
    long end;
    private final long THRESHOLD=100000L;

    public ForkJoinStudy(long start,long end){
        this.start=start;
        this.end=end;
    }
    @Override
    protected Long compute() {
        long length=end-start;
        if (length<=THRESHOLD){
            long sum=0;
            for (long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else {
            long middle=(start+end)/2;
            ForkJoinStudy left=new ForkJoinStudy(start,middle);
            left.fork();//拆分子任务，压入队列
            ForkJoinStudy right=new ForkJoinStudy(middle+1,end);
            right.fork();
            return  left.join()+right.join();
        }
    }
}
