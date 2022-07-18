package Study.IOStudy.objectStream;

/**
 * @ClassName ObjectStreamStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/9 下午11:03
 * @Version 1.0
 */

import java.io.*;
import java.util.Scanner;

/**
 * 操作对象的流：序列化-反序列化
 * OpjectInputStream, ObjectInputStream
 * */
public class ObjectStreamStudy {
    public static void main(String[] args) throws Exception {
       // test2();
        saveClass();
        readClass();
    }

    //将对象存到文件中,对象必须实现Serializable 接口。但是当person序列化之后，再增加属性或者方法，反序列化时会报错。解决方式：给类增加序列号
    public static void saveClass() throws IOException {
        String path="src/main/java/Source/";
        ObjectOutputStream ob=new ObjectOutputStream(new
                FileOutputStream(path+"ObjectOutputStream.txt"));

        ob.writeObject(new Person("xiaofang",11));
        ob.close();
    }

    //读取存储对象的文件
    public static void readClass() throws Exception{
        String path="src/main/java/Source/";
        ObjectInputStream oi=new ObjectInputStream(
                new FileInputStream(path+"ObjectOutputStream.txt"));

        Person p=(Person) oi.readObject();
        System.out.println(p);

        oi.close();
    }

    public static void test() throws Exception{
        //序列化
        ObjectOutputStream oo=new ObjectOutputStream(new FileOutputStream("src/main/java/Source/ObjectIOStudyText.txt"));
        oo.writeObject("haha");
        //反序列化
        ObjectInputStream o=new ObjectInputStream(new FileInputStream(new File("src/main/java/Source/ObjectIOStudyText.txt")));
        Object a=o.readObject();
        System.out.println(a);
        oo.close();
        o.close();
    }

    public static void test2() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/main/java/Source/BufferedReaderWriterTest.txt"));
        String s=br.readLine();
        while (!s.equals("quit")){
            bw.write(s);
            bw.newLine();
            s=br.readLine();
        }
        bw.close();
        br.close();
    }

}
