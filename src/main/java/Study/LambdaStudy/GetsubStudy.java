package Study.LambdaStudy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName GetsubStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/13 下午8:20
 * @Version 1.0
 */
//正则表达式：获取
public class GetsubStudy {
    public static void main(String[] args) {
        getDemo();
    }
    public static void getDemo(){
        String str="ming tian jiu yao fang jia le, da jia.";
        String reg="\\b[a-z]{3}\\b";//查询三个字母的子串 \\b为单词边界
        //将规则封装成对象
        Pattern p=Pattern.compile(reg);

        //将正则表达式和字符串关联,获取引擎m，PS:其实String中的match方法，用的就是m.matches方法
        Matcher m= p.matcher(str);

        //将规则运用到字符串上，并进行符合规则的子串查找，
        // 但是只会找到第一个，所以要循环
//        boolean b=m.find();
//
//        System.out.println(b);
//
//        System.out.println(m.group());//获取匹配后的结果

        while (m.find())//先find再 group
        {
            System.out.println(m.group());
            //字符串的开始位置及结束位置
            System.out.println(m.start()+"...."+m.end());

        }
    }
}
