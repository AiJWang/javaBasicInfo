package Study.ThreadLock;

/**
 * @ClassName LockMain
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午7:41
 * @Version 1.0
 */
public class LockMain {
    public static void main(String[] args) {
        LockResourse lockResourse = new LockResourse();

        LockSetter output2 = new LockSetter(lockResourse);
        LockSetter output3 = new LockSetter(lockResourse);
        LockGetter input1 = new LockGetter(lockResourse);
        LockGetter input2 = new LockGetter(lockResourse);

//        input.resourses1.out();
//        output1.resourses1.out();
        Thread thread = new Thread(input1);
        Thread thread3 = new Thread(input2);
        Thread thread1 = new Thread(output2);

        Thread thread2 = new Thread(output3);

        thread.start();
        thread3.start();
        thread1.start();
        thread2.start();

    }
}
