package Study.StringLearn;

/**
 * @ClassName StringBufferLearn
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/2 上午10:51
 * @Version 1.0
 */

/**
 * stringBuffer：是个容器，字符串缓冲期
 * 添加
 * 1：append（）：字符串后面添加字符串
 * 2、insert（index,str）：插入数据
 * 删除
 * 3、delete（start，end）：包含start，不包含end
 * 4、deleteCharAt（）：删除单个字符
 * 修改：
 * replace（start，end，str）
 * 反转：
 * reverse()
 * <p>
 * getChars(start,end,char[],begin):将字符串指定开始结束位置，放入char类型数组中，并设置开始位置begin
 * <p>
 * StringBuilder和StringBuffer一样，建议使用StringBuilder(单线程使用)
 * StringBuffer多线程使用的，有锁，效率不高
 */
public class StringBufferLearn {
    public static void main(String[] args) {
        dele();
        update();

        StringBuffer sb = new StringBuffer("javaTest");
        char[] chs = new char[5];
        sb.getChars(1, 5, chs, 1);
        for (int i = 0; i < chs.length; i++) {
            System.out.println("chs[" + i + "]=" + chs[i]);
        }
        StringBuilder stringBuilder = new StringBuilder("javaStudy_01");

    }

    public static void update() {
        StringBuffer sb = new StringBuffer("javaLearn");
        sb.replace(1, 3, "spring");
        System.out.println(sb.toString());

    }

    public static void dele() {
        StringBuffer sb = new StringBuffer("javaTest");
        //删除123位置数据
        sb.delete(1, 4);
        System.out.println(sb);
        //删除单个字符
        sb.deleteCharAt(1);
    }

    public static void add() {
        StringBuffer sb = new StringBuffer("java");
        sb.append(" learn");
        System.out.println(sb);
        sb.insert(5, "2");
        System.out.println(sb);
    }

}
