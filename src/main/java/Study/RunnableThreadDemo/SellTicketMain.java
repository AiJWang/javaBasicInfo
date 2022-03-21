package Study.RunnableThreadDemo;

/**
 * @ClassName SellTicketMain
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/26 下午8:53
 * @Version 1.0
 */
public class SellTicketMain {
    public static void main(String[] args) {
        SellTicketRunnable sellTicketRunnable = new SellTicketRunnable();
        Thread t = new Thread(sellTicketRunnable);
        Thread t1 = new Thread(sellTicketRunnable);
        //Thread t2=new Thread(sellTicketRunnable);
//        Thread t3=new Thread(sellTicketRunnable);
        t.start();
        try {
            Thread.sleep(10);
        } catch (Exception e) {
        }
        sellTicketRunnable.flag = false;
        t1.start();
//        t2.start();
//        t3.start();
    }
}
