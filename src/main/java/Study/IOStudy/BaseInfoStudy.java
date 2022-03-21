package Study.IOStudy;

/**
 * @ClassName BaseInfoStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/14 下午9:08
 * @Version 1.0
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *IO流分为字符流和字节流
 *
 * 字符流：Writer；Reader
 *
 * FileReader;FileWriter;BufferedReader;BufferedWriter
 *
 * 字节流：InputStream；OutputStream
 *
 * FileInputStream,FileOutputStream,BufferedInputStream,BufferedOutputStream
 *
 * 流对象的基本规律：
 * 明确两个内容：
 * 1、明确数据来源和数据目的
 * 源：输入流。InputStream; Reader
 * 目的：输出流。OutputStream,Writer
 *
 * 2、操作的数据是否为纯文本
 * 是纯文本：字符流
 * 不是：字节流
 *
 * 转换流是字符和字节之间的桥梁，通常，涉及到字符编码转换时用到
 * 用法,可以设置编码格式：
 * BufferedReader bufferedReader=new BufferedReader(
 *                 new InputStreamReader(System.in,"UTF-8"));
 *
 * BufferedWriter bufferedWriter=new BufferedWriter(
 *                 new OutputStreamWriter(System.out,"GBK"));
 *
 * InputStreamReader:字节流转化为字符流
 * OutputStreamWriter: 字符流转化为字节流
 **/
public class BaseInfoStudy {
    public static void main(String[] args) throws IOException{
        //read();
        //readInputReader();
        //readInputReaderAndWriter();
        List<Long> a=new ArrayList<>();
        a.add(12312321L);
        a.add(21321321356L);
        System.out.println(a);
    }

    //读取键盘录入
    /**
     * 现在的读取动作相当于读取一行，BufferedReader中的readline方法也可以实现
     * 但是System.in是字节流类型
     *所以需要一个将字节流转换为字符流的工具 InputStreamReader
     * */
    public static void read() throws IOException {
        InputStream in =System.in;
        StringBuilder sb=new StringBuilder();
        while (true){
            int a=in.read();
            if (a=='\r'){
                continue;
            }
            else if (a=='\n')
            {
                String s=sb.toString();
                if ("over".equals(s)){
                    break;
                }
                System.out.println(s.toUpperCase());
                sb.delete(0,sb.length());
            }
            else
                sb.append((char)a);
        }
    }
    //键盘录入，readline方法，字节流转换为字符
    public static void readInputReader() throws IOException{

        //获取键盘录入对象
        InputStream in =System.in;

        //将字节流对象转换为字符流对象，使用转换流 InputStreamReader
        InputStreamReader inputStreamReader=new InputStreamReader(in);

        //为提高效率，使用缓冲区
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String line=null;
        while ((line=bufferedReader.readLine())!=null)
        {
            if (line.equals("over"))
                break;
            System.out.println(line.toUpperCase());
        }
        bufferedReader.close();
    }
    //OutputStreamWriter：字符转字节
    public static void readInputReaderAndWriter() throws IOException{

        //获取键盘录入对象
        //将字节流对象转换为字符流对象，使用转换流 InputStreamReader
        //为提高效率，使用缓冲区

        //键盘录入最常见写法，重点
        BufferedReader bufferedReader=new BufferedReader(
                new InputStreamReader(System.in));

        //输出
        BufferedWriter bufferedWriter=new BufferedWriter(
                new OutputStreamWriter(System.out));


        String line=null;
        while ((line=bufferedReader.readLine())!=null)
        {
            if (line.equals("over"))
                break;
            bufferedWriter.write(line.toLowerCase());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
