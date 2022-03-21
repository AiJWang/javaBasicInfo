package Study.ThreadJoinDemo;

/**
 * @ClassName JoinDemoMain
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/28 上午11:16
 * @Version 1.0
 */
public class JoinDemoMain {
    public static void main(String[] args) throws Exception {
        JoinDemo joinDemo = new JoinDemo();
        Thread thread = new Thread(joinDemo);
        Thread thread1 = new Thread(joinDemo);

        thread.start();
        thread1.start();
        System.out.println("----------------");
        //当A线程执行到B线程的join方法时，B线程就会获得执行权利，直到B执行结束，A才能继续开始争夺执行权
        //可用于加塞
        thread.join();
        //释放执行权
        thread.yield();

        for (int i = 0; i < 60; i++) {
            System.out.println(Thread.currentThread().getName() + "....." + i);
        }

    }
}
