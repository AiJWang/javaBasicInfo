package Study.LambdaStudy;

/**
 * @ClassName PaChong
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/13 下午10:04
 * @Version 1.0
 */
//判断邮箱规则
public class PaChong {
    public static void main(String[] args) {
        String s="wang_ew23@sina.com";
        String grex="[a-zA-Z0-9_]+@[a-zA-Z]+(\\.[a-zA-Z]+)+";

        System.out.println(s.matches(grex));
    }
}
