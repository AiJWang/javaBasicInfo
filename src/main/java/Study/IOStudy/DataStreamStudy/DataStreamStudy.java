package Study.IOStudy.DataStreamStudy;

/**
 * @ClassName DataStreamStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/10 下午8:55
 * @Version 1.0
 */

import java.io.*;

/**
 * DataInputStreaml;DataOutputStream
 *
 * 用于操作基本数据类型的数据流的对象
 *
 * 凡事操作基本数据类型，就用这个
 *
 * */
public class DataStreamStudy {
    public static void main(String[] args) throws IOException {
        writeData();
        readTest();
    }

    public static void writeData() throws IOException {
        File f=new File("demo/src" +
                "/main/resources/ResourseForIOStudy/IOStudy/DataStream.txt");
        DataOutputStream da=new DataOutputStream(new FileOutputStream(f));
        da.writeInt(123); //4个字节
        da.writeBoolean(true); //1个字节
        da.writeDouble(12.32);//8个字节
        //以UTF-8修改的格式写入,
        da.writeUTF("以UTF-8修改格式写入");
        da.close();
    }

    public static void readTest() throws IOException{
        File f=new File("demo/src" +
                "/main/resources/ResourseForIOStudy/IOStudy/DataStream.txt");
        DataInputStream da=new DataInputStream(new FileInputStream(f));

        //什么顺序写的，就得什么顺序读
        int num=da.readInt();
        boolean ba=da.readBoolean();
        double dab=da.readDouble();
        String sr=da.readUTF();

        System.out.println("num: "+num);
        System.out.println("ba: "+ba);
        System.out.println("dab: "+dab);
        System.out.println("sr: "+sr);
        da.close();
    }
}
