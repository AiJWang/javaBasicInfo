package Study.StringLearn;

/**
 * @ClassName StringLearn
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/28 下午12:12
 * @Version 1.0
 */
public class StringLearn {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        String c = "abc";
        int d = 123;
        String e = String.valueOf(d);
        // b内存中有2个对象 a和c有1个 equals判断内容是否相等

        /**
         * 常见方法
         * 1、长度  length()
         * 2、第一次出现的位置:indexof
         * 3、以xx开头：str.startWith()
         * 4、以xx结尾：str.endsWith()
         * 5、包含：str.contains(str1)
         * 6、将字符数组转换为字符串：
         *     6.1 String str=new String(char[] a)
         *     6.2 String valueOf()
         *
         * 7、将字符串转换为字符数组：char[] a =str.toCharArray()
         * 8、替换：replace(oldStr,newStr)
         * 9、切割：String[] a=split()
         * 10、获取子字符串：str.subString(begin,end)
         * 11、去除字符串2端空格：str.trim()
         * 12、自然顺序的比较：str.compairTo(str1)，大于0 说明str大；等于0 相等；小于0 str1大
         * */
        System.out.println(a.length());
        String name = "zhangsan,lisi,wangwu,fanliu";
        String[] names = name.split(",");
        System.out.println(names.length);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        System.out.println("subString" + name.substring(1, name.length()));

        String x = findString("qwertyuiop", "adsweftyuiklm");

    }

    public static String findString(String a, String b) {
        String str;
        String max = a.length() >= b.length() ? a : b;
        String min = max == a ? b : a;
        System.out.println("max...." + max);
        System.out.println("min...." + min);
        for (int i = 0; i < min.length(); i++) {
            for (int j = 0, z = min.length() - i; z < min.length() + 1; j++, z++) {
                str = min.substring(j, z);
                System.out.println("取得的字符串" + str);
                if (max.contains(str)) {
                    System.out.println("符合的字符传。。。。。" + str);
                    return str;
                }
            }
        }
        return "";

    }
}
