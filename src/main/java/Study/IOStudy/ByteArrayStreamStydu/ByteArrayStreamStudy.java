package Study.IOStudy.ByteArrayStreamStydu;

/**
 * @ClassName ByteArrayStreamStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/11 下午3:26
 * @Version 1.0
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 操作字节数组的流对象
 *
 * ByteArrayInputStream：在构造的时候，需要接收数据源，并且数据源是个字节数组
 *
 * ByteArrayOutputStream：在构造的时候，不需定义数据目的，因为该对象中已经
 * 内部封装了可变长度的字节数组，这就是数据目的
 *
 * 因为着两个刘对象都操作的数组，并没有使用系统资源，所以，不需要close关闭
 *
 * 源： 内存 ArrayStream，硬盘 FileStream，键盘 System.in
 * 目的：内存 ArrayStream，硬盘 FileStream，控制台 System.out
 *
 * 用流的技术写数组
 *
 * 同理的：CharArrayReader,CharArrayWriter
 *       StringReader, StringWriter
 * */
public class ByteArrayStreamStudy {
    public static void main(String[] args) {
        readTest();
    }

    public static void readTest(){
        //数据源
        ByteArrayInputStream bi=new ByteArrayInputStream("你好".getBytes());

        //数据目的
        ByteArrayOutputStream bo=new ByteArrayOutputStream();

        int by=0;

        while ((by=bi.read())!=-1)
        {
            bo.write(by);
        }
        System.out.println(bo.toString());

        //将数据写到输出流中
        //bo.writeTo(new FileOutputStream("a.txt"));

    }
}
