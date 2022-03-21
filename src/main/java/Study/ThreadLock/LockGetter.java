package Study.ThreadLock;

/**
 * @ClassName LockGetter
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午7:41
 * @Version 1.0
 */
public class LockGetter implements Runnable {
    LockResourse lockResourse;

    LockGetter(LockResourse lockResourse) {
        this.lockResourse = lockResourse;
    }

    public void run() {
        while (true)
            try {
                lockResourse.getall();
            } catch (Exception e) {
            }
    }
}
