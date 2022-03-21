package Study.thread;

/**
 * @ClassName ThreadDemo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/25 上午11:29
 * @Version 1.0
 */

/**
 * stop() 线程停止
 * sleep() 沉睡
 * wait()等待
 * notify() 唤醒 等待的
 */

public class ThreadDemo extends Thread {
    //复写父类run方法
    private String name;

    ThreadDemo(String name) {
        super(name);
    }

    ThreadDemo() {
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName() + " demo run: " + i);
        }
    }
}
