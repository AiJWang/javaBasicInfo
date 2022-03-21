package Study.IOStudy.ziJieLiu;

/**
 * @ClassName ZiJieLiuBuffered
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/17 下午8:45
 * @Version 1.0
 */

import java.io.*;

/**
 * bufferedOutputStream
 * bufferedInputStream
 *
 * 字节流的缓冲区
 * */
public class ZiJieLiuBuffered {
    public static void main(String[] args) throws IOException {
        copyPicture1();
    }

    public static void copyPicture1() throws IOException{
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/bu1.png";
        String path1="demo/src/main/resources/ResourseForIOStudy/IOStudy/bu2.png";

        FileInputStream fis=new FileInputStream(path);
        FileOutputStream fos=new FileOutputStream(path1);

        BufferedInputStream bi=new BufferedInputStream(fis);
        BufferedOutputStream bo=new BufferedOutputStream(fos);

        byte[] a=new byte[bi.available()];
        bi.read(a);
        bo.write(a);

        bi.close();
        bo.close();

    }
}
