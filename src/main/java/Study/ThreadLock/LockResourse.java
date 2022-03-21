package Study.ThreadLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockResourse
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午7:27
 * @Version 1.0
 */

/**
 * 主要就是说线程锁的
 * Lock替代synchronized
 * condition替换了wait,notify,notifyall
 */
public class LockResourse {
    private String name;
    private int num = 0;
    private boolean flag = false;

    private Lock lock = new ReentrantLock();
    //同一个lock，可以对应多个condition
    private Condition condition_set = lock.newCondition();
    private Condition condition_get = lock.newCondition();

    public void setall(String name) throws Exception {
        lock.lock();
        try {
            while (flag) {
                condition_set.await();//设置值的线程等待
            }
            this.name = name;
            num++;
            System.out.println("生产" + "....." + num);
            flag = true;
            condition_get.signal();//取值的线程唤醒
        } finally {
            lock.unlock();//释放锁的动作一定要执行
        }


    }

    public void getall() throws Exception {
        lock.lock();
        try {
            while (!flag) {
                condition_get.await();
            }
            System.out.println("消费" + "......" + num);
            flag = false;
            condition_set.signal();
        } finally {
            lock.unlock();
        }
    }
}


