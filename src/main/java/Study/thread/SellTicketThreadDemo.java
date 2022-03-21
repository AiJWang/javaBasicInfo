package Study.thread;

/**
 * @ClassName SellTicketThreadDemo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/25 下午12:19
 * @Version 1.0
 */
public class SellTicketThreadDemo extends Thread {
    private static int tick = 100;

    public void run() {
        while (true) {
            if (tick > 0) {
                System.out.println(currentThread().getName() + " sell " + tick);
                tick--;
            } else {
                break;
            }

        }
    }
}
