package Study.ThreadTongXin;

/**
 * @ClassName Resourses1
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午4:21
 * @Version 1.0
 */
//单个线程进数据，单个线程取数据
public class Resourses1 {
    private String name;
    private String sex;
    private boolean flag = true;

    public synchronized void setAll(String name, String sex) {
        if (flag) {
            try {
                this.wait();
            } catch (Exception e) {
            }
        }
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }

    public synchronized void out() {
        if (!flag) {
            try {
                this.wait();
            } catch (Exception e) {
            }
        }
        System.out.println(name + "......" + sex);
        flag = false;
        this.notify();

    }

}
