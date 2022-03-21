package Study.IOStudy.objectStream;

/**
 * @ClassName ObjectStreamStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/9 下午11:03
 * @Version 1.0
 */

import java.io.*;

/**
 * 操作对象的流：
 * OpjectInputStream, ObjectInputStream
 * */
public class ObjectStreamStudy {
    public static void main(String[] args) throws Exception {
        saveClass();
        readClass();
    }

    //将对象存到文件中,对象必须实现Serializable 接口
    public static void saveClass() throws IOException {
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/";
        ObjectOutputStream ob=new ObjectOutputStream(new
                FileOutputStream(path+"ObjectOutputStream.txt"));

        ob.writeObject(new Person("xiaofang",11));
        ob.close();
    }

    //读取存储对象的文件
    public static void readClass() throws Exception{
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/";
        ObjectInputStream oi=new ObjectInputStream(
                new FileInputStream(path+"ObjectOutputStream.txt"));

        Person p=(Person) oi.readObject();
        System.out.println(p);

        oi.close();
    }

}
