package Study.RunnableThreadDemo;

/**
 * @ClassName SellTicketRunnable
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/26 下午8:49
 * @Version 1.0
 */
public class SellTicketRunnable implements Runnable {
    private int tick = 1000;
    Object object = new Object();
    public boolean flag = true;

    public void run() {
        if (flag) {
            while (true) {
                synchronized (this) {
                    if (tick > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                        }
                        System.out.println(Thread.currentThread().getName() + " sell " + tick--);

                    } else {
                        break;
                    }
                }

            }
        } else {
            while (true)
                show();
        }
    }

    public synchronized void show() {
        if (tick > 0) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
            System.out.println(Thread.currentThread().getName() + " sell " + tick--);

        }
    }

}

