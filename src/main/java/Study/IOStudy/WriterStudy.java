package Study.IOStudy;

/**
 * @ClassName WriterStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/14 下午9:10
 * @Version 1.0
 */

import java.io.FileWriter;
import java.io.IOException;

/**
 * Writer:
 * 专门用于操作文件的子类对象，FileWriter。后缀是父类名，前缀名是该流对象的功能
 *
 * IO异常的处理方式
 * */
public class WriterStudy {
    public static void main(String[] args) throws IOException {

        //IOException处理
        ioExceptionTest();
        //文件末尾添加数据
        appendOldfile();
    }
    public static void writerTest() throws IOException{
        //创建一个FileWriter对象，该对象一初始化就必须明确要被操作的文件
        //而且该文件会被创建到指定目录下，如果该目录下已经有了同名文件，会被覆盖
        String filePath="ResourseForIOStudy/IOStudy/WriterTest.txt";
        FileWriter fw=new FileWriter(filePath);
        //这时候没有写到文件中，写到流中去了
        fw.write("IO test");
        //刷新流对象缓冲中的数据，将数据写到文件中
        fw.flush();

        fw.write("IO closed");

        //关闭流资源，关闭之前刷新一遍流资源，将缓冲中的写到文件中
        fw.close();
    }

    public static void ioExceptionTest(){
        String filePath="ResourseForIOStudy/IOStudy/IOExceptionTest.txt";
        //一定要将变量定义在外边，因为在try代码块中定义的变量在finally中访问不到
        FileWriter fw=null;
        try {
            fw=new FileWriter(filePath);
            fw.write("Exception Test");
        }catch (IOException e){
            System.out.println(e.toString());
        }finally {
            //fw.close也有可能出现异常，所以必须也得try一下
            try {
                //必须进行一下非null的判断，不然若fw=null，会报空指针异常
                if (null!=fw)
                    fw.close();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    //不重新覆盖文件，在文件的末尾处续写
    public static void appendOldfile(){
        String filePath="ResourseForIOStudy/IOStudy/IOExceptionTest.txt";
        //一定要将变量定义在外边，因为在try代码块中定义的变量在finally中访问不到
        FileWriter fw=null;
        try {
            fw=new FileWriter(filePath,true);
            fw.write("\nnew words");
        }catch (IOException e){
            System.out.println(e.toString());
        }finally {
            //fw.close也有可能出现异常，所以必须也得try一下
            try {
                //必须进行一下非null的判断，不然若fw=null，会报空指针异常
                if (null!=fw)
                    fw.close();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
