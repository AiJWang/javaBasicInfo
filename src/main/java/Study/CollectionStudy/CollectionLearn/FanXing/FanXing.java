package Study.CollectionStudy.CollectionLearn.FanXing;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @ClassName FanXing
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/7 上午11:56
 * @Version 1.0
 */

/**
 * 之前容器中存的是各种对象，存在数据类型转换异常等问题，泛型避免了强制转化的麻烦
 * <p>
 * 泛型格式：通过<>来定义要引用的操作类型，通常在集合框架中很常见，<>就是为了接受类型，
 * 必须是引用数据类型
 * 范型类： public class demo<T>
 * 泛型方法：public static <Q> void show(Q q),<T>放在返回值类型前面
 * 泛型通配符，不明确类型的时候使用：<?>
 * 泛型限定:<? extends Father> 允许传入Father及其子类
 * <? super son> 允许传入son及其父类
 */
public class FanXing {
    public static void main(String[] args) {
        //这个<Sring> 就是传说中的泛型
        ArrayList<String> li = new ArrayList<String>();
        li.add("help");
        li.add("test");

        //迭代器页必须指定泛型<String>
        for (Iterator<String> it = li.iterator(); it.hasNext(); )
            System.out.println(it.next());

        testFanXingLei();

        testFanXingMethod();
    }

    //泛型类测试方法
    public static void testFanXingLei() {
        FanXingLei<TestForFanXing> fa = new FanXingLei<TestForFanXing>();
        fa.setQ(new TestForFanXing());
        TestForFanXing te = fa.getQ();
    }

    //泛型方法 的测试方法
    public static void testFanXingMethod() {
        FanXingMethod fa = new FanXingMethod();
        fa.show("test");
        fa.show(new Integer("16"));
    }

    //泛型占位符:<?> 或者就得写成 public static <T> void show(ArrayList<T> a1)，定义成泛型方法
    public static void zhanWeiFuTest(ArrayList<?> al) {
        Iterator<?> it = al.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }

}
