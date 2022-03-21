package Study.ThreadTongXin;

/**
 * @ClassName MultInputOutput
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午6:39
 * @Version 1.0
 */
public class MultInputOutput {
    public static void main(String[] args) {
        MultiplyResouese resourses1 = new MultiplyResouese();

        Output2 output2 = new Output2(resourses1);
        Output2 output3 = new Output2(resourses1);
        Input1 input1 = new Input1(resourses1);
        Input1 input2 = new Input1(resourses1);

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
