package Study.thread;

/**
 * @ClassName SellTicketMain
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/25 下午12:28
 * @Version 1.0
 */
public class SellTicketMain {
    public static void main(String[] args) {
        SellTicketThreadDemo sellTicketThreadDemo = new SellTicketThreadDemo();
        sellTicketThreadDemo.start();
        SellTicketThreadDemo sellTicketThreadDemo1 = new SellTicketThreadDemo();
        sellTicketThreadDemo1.start();
    }
}
