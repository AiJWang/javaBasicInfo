package Study.IOStudy.daYinLiu;

/**
 * @ClassName DaYinLiu
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/9 下午10:14
 * @Version 1.0
 */

import java.io.*;

/**
 * 打印流：提供打印方法，将各种数据类型数据原样打印
 *
 * 字节打印流：
 * printStream
 *  构造函数如下：
 *  1、file对象 File
 *  2、字符串路径 String
 *  3、字节输出流 OutputStream
 *
 * 字符打印流：更加常用
 * printWriter
 * 构造函数如下：
 * 1、file对象 File
 * 2、字符串路径 String
 * 3、字节输出流 OutputStream
 * 4、字符输出流 Writer
 *
 *
 * */
public class DaYinLiu {
    public static void main(String[] args) throws IOException {
        //获取键盘录入
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));

        //后面加了true，就会自动刷新,打印出来
        PrintWriter pt=new PrintWriter(System.out,true);

        //存到文件中
        PrintWriter printWriter=new PrintWriter(new FileOutputStream
                ("demo/src/main/resources/ResourseForIOStudy/IOStudy/DayinLiu.txt"),true);

        String line=null;

        while ((line=bu.readLine())!=null){
            if ("over".equals(line))
                break;

            pt.println(line.toUpperCase());
            printWriter.println(line);
        }
    }
}
