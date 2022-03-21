package Study.MapStudy;

//import apple.laf.JRSUIUtils;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @ClassName StringCountTest
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/8 下午12:52
 * @Version 1.0
 */
//查询一个字符串中重复字符的数量:faheoiwvncdskahfeouwgadsarqwe,并返回a(1)b(3)
public class StringCountTest {
    public static void main(String[] args) {
        String s = st("asdfghzxcsdvbsf");
        System.out.println(s);

    }

    public static String st(String string) {
        //字符传转化为字符数组
        char[] chars = string.toCharArray();
        //建map
        TreeMap<Character, Integer> treeMap = new TreeMap<Character, Integer>();
        for (int i = 0; i < chars.length; i++) {
            if (null == treeMap.get(chars[i])) {
                treeMap.put(chars[i], 1);
            } else
                treeMap.put(chars[i], treeMap.get(chars[i]) + 1);
        }
        Set<Character> s1 = treeMap.keySet();
        StringBuilder sb = new StringBuilder();
        for (Iterator<Character> it = s1.iterator(); it.hasNext(); ) {
            Character a = it.next();

            sb.append(a + "(" + treeMap.get(a) + ")");
        }
        return sb.toString();

    }
}
