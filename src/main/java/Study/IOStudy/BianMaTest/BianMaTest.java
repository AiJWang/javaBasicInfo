package Study.IOStudy.BianMaTest;

/**
 * @ClassName BianMaTest
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/11 下午3:45
 * @Version 1.0
 */

import java.io.*;
import java.util.Arrays;

/**
 * ASCII: 美国标准信息交换码
 *        用一个字节的7位可以表示
 * ISO8859-1：欧洲码表
 *        用一个字节的8位表示
 * GBK：中文码表 2个字节
 *
 * Unicode：国际标准码 2个字节表示
 *
 * UTF-8： 最多用三个字节表示一个字符，因为GBK和UTF-8中同一个码对应的文字不同，所以会有编码问题，3字节
 *
 * 编码：字符串变字节数组
 *
 * 解码：字节数组变字符串
 *
 * String--> byte[] : str.getBytes()，用的默认编码，也可以制定编码 str.getBytes("GBK")
 *
 * byte[]-->String :  new String(byte)，用的默认编码，也可以制定编码new String(byte,"GBK")
 *
 * 277集再看一遍
 * */
public class BianMaTest {
    public static void main(String[] args) throws Exception{
        //writeText();
        //readText();

        String s="你好";
        //编码
        byte[] b1=s.getBytes("UTF-8");

        System.out.println(Arrays.toString(b1));

        //解码
        String s1=new String(b1,"GBK");

        System.out.println(s1);

        //解码错误，需要重新编码，再次解码
        String s2="你好";
        //编码
        byte[] b2=s.getBytes("UTF-8");

        System.out.println(Arrays.toString(b2));

        //解码
        String ss2=new String(b2,"GBK");
        System.out.println(ss2);

        //重新编码
        byte[] bb2=ss2.getBytes("GBK");

        System.out.println(Arrays.toString(bb2));
        //重新解码
        String sss2=new String(bb2,"UTF-8");

        System.out.println(sss2);


    }

    public static void writeText() throws IOException {
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/utf.txt";
        File f=new File(path);

        //默认编码格式是UTF-8
        OutputStreamWriter ows=new OutputStreamWriter(new FileOutputStream(f),
                "UTF-8");

        ows.write("你好");

        ows.close();

        String path1="demo/src/main/resources/ResourseForIOStudy/IOStudy/gbk.txt";
        File f1=new File(path1);

        OutputStreamWriter ows1=new OutputStreamWriter(new FileOutputStream(f1),
                "GBK");

        ows1.write("你好");

        ows1.close();


    }
    public static void readText() throws IOException {
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/utf.txt";
        File f=new File(path);

        //默认编码格式是UTF-8
        InputStreamReader ows=new InputStreamReader(new FileInputStream(f),"GBK");
        char[] buf=new char[10];

        int len=ows.read(buf);

        String s=new String(buf,0,len);

        System.out.println(s);

        ows.close();
    }
}
