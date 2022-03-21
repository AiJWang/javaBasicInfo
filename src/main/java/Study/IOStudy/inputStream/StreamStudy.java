package Study.IOStudy.inputStream;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName StreamStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/3 下午3:43
 * @Version 1.0
 */
public class StreamStudy {
    public static void main(String[] args) throws IOException {
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/Linux.pptx";
        String path1="demo/src/main/resources/ResourseForIOStudy/IOStudy/Linux1.pptx";

        FileInputStream fis=new FileInputStream(path);
        FileOutputStream fos=new FileOutputStream(path1);

        MyBufferedInputStream bi=new MyBufferedInputStream(fis);
        BufferedOutputStream bo=new BufferedOutputStream(fos);
        int num=0;
        while ((num=bi.myRead())!=-1)
        {
            bo.write(num);
        }

        bi.myClose();
        bo.close();
    }
}
