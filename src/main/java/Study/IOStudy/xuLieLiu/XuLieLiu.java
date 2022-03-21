package Study.IOStudy.xuLieLiu;

/**
 * @ClassName XuLieLiu
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/9 下午10:27
 * @Version 1.0
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 序列流: 将多个流变成1个大的流
 * SequenceInputStream
 * 应用：多个源向一个目的文件写数据
 *
 * 文件切割再整合自己练习
 * */
public class XuLieLiu {
    public static void main(String[] args) throws IOException {
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/";
        Vector<FileInputStream> ve=new Vector<>();
        ve.add(new FileInputStream(path+"1.txt"));
        ve.add(new FileInputStream(path+"2.txt"));
        ve.add(new FileInputStream(path+"3.txt"));

        Enumeration<FileInputStream> en= ve.elements();

        SequenceInputStream se=new SequenceInputStream(en);

        FileOutputStream fileOutputStream=new FileOutputStream(path+"4.txt");
        byte[] b=new byte[1024];
        int num=0;
        while ((num=se.read(b))!=-1){
            fileOutputStream.write(b,0,num);
        }

        fileOutputStream.close();
        se.close();

    }
}
