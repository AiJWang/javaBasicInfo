package Study.ThreadTongXin;

/**
 * @ClassName Output2
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午6:38
 * @Version 1.0
 */
public class Output2 implements Runnable {
    MultiplyResouese multiplyResouese;

    Output2(MultiplyResouese multiplyResouese) {
        this.multiplyResouese = multiplyResouese;
    }

    public void run() {
        while (true)
            multiplyResouese.getall();
    }
}
