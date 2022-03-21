package Study.ThreadLock;

/**
 * @ClassName LockSetter
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午7:41
 * @Version 1.0
 */
public class LockSetter implements Runnable {
    LockResourse lockResourse;

    LockSetter(LockResourse lockResourse) {
        this.lockResourse = lockResourse;
    }

    public void run() {
        while (true)
            try {
                lockResourse.setall("生产");
            } catch (Exception e) {
            }
    }

}
