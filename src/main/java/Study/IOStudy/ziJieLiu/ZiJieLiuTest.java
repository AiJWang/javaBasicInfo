package Study.IOStudy.ziJieLiu;

/**
 * @ClassName ZiJieLiuTest
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/17 下午8:05
 * @Version 1.0
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 字节流：操作图片数据 InputStream(读),OutputStream（写）
 * FileInputStream,FileOutputStream
 *
 * */
public class ZiJieLiuTest {
    public static void main(String[] args) throws Exception{
        //writeTest();
//        fileInputTest();
//        fileInputTest2();
//        fileInputTest3();
        copyPictures();
    }

    public static void writeTest() throws IOException {
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/FileOUtputWriter.txt";
        FileOutputStream fo=new FileOutputStream(path);
        //字节流不需要刷新
        fo.write("javatest".getBytes());

        fo.close();
    }

    public static void fileInputTest() throws IOException{
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/FileOUtputWriter.txt";
        FileInputStream fi=new FileInputStream(path);
        int num=0;
        while ((num=fi.read())!=-1){
            System.out.println(num+": "+(char)num);
        }
    }

    public static void fileInputTest2() throws IOException{
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/FileOUtputWriter.txt";
        FileInputStream fi=new FileInputStream(path);
        byte[] ca=new byte[1024];
        int num=0;
        while ((num=fi.read(ca))!=-1){
            System.out.println(new String(ca,0,num));
        }

    }

    public static void fileInputTest3() throws IOException{
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/FileOUtputWriter.txt";
        FileInputStream fi=new FileInputStream(path);
        // fi.available() 返回字符数 int，慎用
        byte[] ca=new byte[fi.available()];
        fi.read(ca);
        System.out.println(Arrays.toString(ca));


    }
    public static void copyPictures(){
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/bu1.png";
        String path1="demo/src/main/resources/ResourseForIOStudy/IOStudy/bu3.png";

        FileInputStream in=null;
        FileOutputStream out=null;
        try{
            in=new FileInputStream(path);
            out=new FileOutputStream(path1);

            byte[] b=new byte[1024];
            int num=0;

            while ((num=in.read(b))!=-1){
                out.write(b,0,num);
            }
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                in.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
            try {
                out.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
