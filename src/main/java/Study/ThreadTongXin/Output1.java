package Study.ThreadTongXin;

/**
 * @ClassName Output1
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午4:27
 * @Version 1.0
 */
public class Output1 implements Runnable {
    public Resourses1 resourses1;

    Output1(Resourses1 resourses1) {
        this.resourses1 = resourses1;
    }

    public void run() {
        while (true) {
            resourses1.out();
        }
    }


}
