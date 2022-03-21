package Study.IOStudy.ReaderStudy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName ReaderStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/14 下午10:05
 * @Version 1.0
 */
public class ReaderStudy {
    public static void main(String[] args) throws IOException {
        //readTest();

        //通过字符数组读取
        //readByCharArrayTest();

        //System.out.println(System.currentTimeMillis());

        //copyOneByOne();

        copyAll();
    }
    //每次读一个字符
    public static void readTest() throws IOException {
        String filePath="demo/src/main/resources/ResourseForIOStudy/IOStudy/IOExceptionTest.txt";
        FileReader fr=new FileReader(filePath);
        //返回int型,一次读一个，并且会记住位置，读到末尾的时候，返回-1
        int num;
        while ((num=fr.read())!=-1){

            System.out.println("ch: "+(char)num+".."+num);
        }

        fr.close();

    }
    //通过字符数组读取
    public static void readByCharArrayTest() throws IOException {
        String filePath="demo/src/main/resources/ResourseForIOStudy/IOStudy/IOExceptionTest.txt";
        FileReader fr=new FileReader(filePath);
        int num=0;
        //一般定义都是1024的长度
        char[] result=new char[1024];
        //读到末尾返回-1
        while ((num=fr.read(result))!=-1){
            //将读出来的字符放到一个字符数组中
            System.out.println(Arrays.toString(result));
            System.out.println(new String(result,0,num));
        }
    }

    //文件复制
    public static void copyOneByOne() {

        String readFilePath="demo/src/main/resources/ResourseForIOStudy/IOStudy/IOExceptionTest.txt";
        String writeFilePath="demo/src/main/resources/ResourseForIOStudy/IOStudy/IOExceptionTestCopy.txt";
        FileReader fr=null;
        FileWriter fw=null;
        int a;
        try{
             fr=new FileReader(readFilePath);
             fw=new FileWriter(writeFilePath);
             while ((a=fr.read())!=-1){
                 System.out.println("cha: "+(char)a);
                 fw.write((char) a);
             }


        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (null!=fr)
                    fr.close();
                if (null!=fw)
                    fw.close();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }

        }

    }
    //文件复制2
    public static void copyAll() {

        String readFilePath="demo/src/main/resources/ResourseForIOStudy/IOStudy/IOExceptionTest.txt";
        String writeFilePath="demo/src/main/resources/ResourseForIOStudy/IOStudy/IOExceptionTestCopy.txt";
        FileReader fr=null;
        FileWriter fw=null;
        char[] re=new char[1024];
        int a=0;
        try{
            fr=new FileReader(readFilePath);
            fw=new FileWriter(writeFilePath);
            while ((a=fr.read(re))!=-1){
                System.out.println("cha: "+new String(re,0,a));
                fw.write(re,0,a);
            }


        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            if (null!=fr){
                try {
                    fr.close();
                }catch (Exception e){
                    throw new RuntimeException("关闭fr报错");
                }
            }
            if (null!=fw){
                try {
                    fw.close();
                }catch (Exception e){
                    throw new RuntimeException("关闭fr报错");
                }

        }

    }
    }
}
