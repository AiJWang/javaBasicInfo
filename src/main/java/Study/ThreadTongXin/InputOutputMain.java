package Study.ThreadTongXin;

/**
 * @ClassName InputOutputMain
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午4:31
 * @Version 1.0
 */
public class InputOutputMain {
    public static void main(String[] args) {
        Resourses1 resourses1 = new Resourses1();

        Output1 output1 = new Output1(resourses1);
        Input input = new Input(resourses1);

//        input.resourses1.out();
//        output1.resourses1.out();
        Thread thread = new Thread(input);
        Thread thread1 = new Thread(output1);

        thread.start();
        thread1.start();
    }
}
