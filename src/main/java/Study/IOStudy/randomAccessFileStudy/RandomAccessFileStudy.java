package Study.IOStudy.randomAccessFileStudy;

/**
 * @ClassName RandomAccessFileStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/10 下午3:23
 * @Version 1.0
 */

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 不是IO体系中的子类，直接继承Object
 *
 * 但是为IO包中成员，因为具备读和写的功能
 * 内部封装了一个数组，通过对数组的指针对数组元素进行操作
 * 通过getFilePointer获取指针位置
 * 同时可以通过seek改变指针位置
 *
 * 可以读写的原理就是内部封装了字节输入和字节输出流
 * 只能操作文件，并且还得设置模式r，rw
 *
 * 如果模式为r：不会创建文件
 * 如果模式为rw：会创建文件
 *
 *
 * */
public class RandomAccessFileStudy {
    public static void main(String[] args) throws IOException {
        writeTest();
        readTest();
        writeTest2();
        readTest();
    }

    public static void writeTest() throws IOException {
        File file=new File("demo/src" +
                "/main/resources/ResourseForIOStudy/IOStudy/randomAc.txt");

        RandomAccessFile ra=new RandomAccessFile(file,"rw");
        ra.write("李四".getBytes());
        ra.writeInt(97);
        ra.write("王五".getBytes());
        ra.writeInt(97);

        ra.close();
    }
    //在指定位置写入
    public static void writeTest2() throws IOException {
        File file=new File("demo/src" +
                "/main/resources/ResourseForIOStudy/IOStudy/randomAc.txt");

        RandomAccessFile ra=new RandomAccessFile(file,"rw");

        //偏移8位，8是字节8个字节
        ra.seek(10*0);

        ra.write("返流".getBytes());
        ra.writeInt(103);

        ra.close();
    }

    public static void readTest() throws IOException {
        File file=new File("demo/src" +
                "/main/resources/ResourseForIOStudy/IOStudy/randomAc.txt");

        RandomAccessFile ra=new RandomAccessFile(file,"r");

        //指针偏移10位
        ra.seek(0);

        //跳过4位
        //ra.skipBytes(4);


        byte[] b=new byte[6];

        ra.read(b);

        System.out.println("name: "+new String(b));

        //读整数
        int age=ra.readInt();

        System.out.println("age: "+age);

        ra.close();
    }
}
