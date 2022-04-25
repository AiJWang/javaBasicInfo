package MsbStudy.HighLevel;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * 字符串学习
 * 字符串底层就是个char数组
 * StringBuilder,StringBuffer：
 *  底层跟String一样，都是char[]
 *  可以多看看源码
 * */
public class StringStudy {
    public static void main(String[] args) {
        String a="abc";
        String b=null;
        //debug看看源码
        String c=a+"ddd";
        System.out.println(a.equals(b));
    }
    //StringBuilder test
    public static void test0(){
        //底层是给char数组初始化，设置长度为16
        StringBuilder sb=new StringBuilder();
        //设置底层数组长度为10
        StringBuilder stringBuilder=new StringBuilder(10);
        //底层，先调了构造器，传入的字符串长度+16的char数组，然后append 字符串
        StringBuilder stringBuilder1=new StringBuilder("fdafda");

    }
}






