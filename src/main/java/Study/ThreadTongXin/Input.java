package Study.ThreadTongXin;

/**
 * @ClassName Input
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午4:23
 * @Version 1.0
 */
public class Input implements Runnable {
    Resourses1 resourses1;

    Input(Resourses1 resourses1) {
        this.resourses1 = resourses1;
    }

    public void run() {
        int x = 0;
        while (true) {

            if (x == 0) {
                resourses1.setAll("mike", "man");
            } else {
                resourses1.setAll("丽丽", "女");
            }
            x = (1 + x) % 2;
        }


    }

}
