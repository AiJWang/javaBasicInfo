package Study.JDK15New;

/**
 * @ClassName NewSepcialTest
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/13 下午6:38
 * @Version 1.0
 */
/**
 * 一：可变参数
 * 可变参数方法 void show(int... a)
 * 相当于传进去一个int类型数组，但是在调用的时候还不用定义数组，直接往里传数
 * 注意事项，一定要把可变参数放在参数列表的最后，不然会报错void show(String string,int...a)
 *
 * 二：静态导入
 * import static java.util.Arrays.*
 * 导入Arrays中所有静态成员，然后调用的时候可以直接用asList等方法
 * 但是当Arrays中的方法和Object中方法重名时，必须加上Arrays.
 * */

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class NewSepcialTest {
    public static void main(String[] args) {
        show(2);
        show(2,3,4,5);

        //静态导入测试
        staticImportTest();
    }
    public static void show(int...a){
        int b=0;
        for (int i:a)
            b=b+i;
        System.out.println(b);
    }

    public static void staticImportTest(){
        int[] a={1,2,3};
        List<int[]> li=asList(a);
        System.out.println(li);
        System.out.println(Arrays.toString(a));
    }
}
