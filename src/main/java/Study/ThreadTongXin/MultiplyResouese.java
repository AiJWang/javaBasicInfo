package Study.ThreadTongXin;

/**
 * @ClassName MultiplyResouese
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午6:13
 * @Version 1.0
 */
//多个线程存数据，多个线程取数据
public class MultiplyResouese {
    private String name;
    private int num = 0;
    private boolean flag = false;

    public synchronized void setall(String name) {
        while (flag) {
            try {
                this.wait();
            } catch (Exception e) {
            }
        }
        this.name = name;
        num++;
        System.out.println("生产" + "....." + num);
        flag = true;
        this.notifyAll();
    }

    public synchronized void getall() {
        while (!flag) {
            try {
                this.wait();
            } catch (Exception e) {
            }
        }
        System.out.println("消费" + "......" + num);
        flag = false;
        this.notifyAll();
    }
}
