package Study.ThreadTongXin;

/**
 * @ClassName Input1
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午6:37
 * @Version 1.0
 */
public class Input1 implements Runnable {
    MultiplyResouese multiplyResouese;

    Input1(MultiplyResouese multiplyResouese) {
        this.multiplyResouese = multiplyResouese;
    }

    public void run() {
        while (true)
            multiplyResouese.setall("生产");
    }

}
