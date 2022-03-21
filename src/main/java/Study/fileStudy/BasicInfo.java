package Study.fileStudy;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName BasicInfo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/8 下午7:13
 * @Version 1.0
 */

/**
 *File 常见方法 ：
 * 1、创建
 *    boolean createNewFile(): 没有文件，就创建，有文件，就不创建
 *    boolean mkdir(): 创建文件夹，只能创建一级
 *    boolean mkdirs(): 创建多级目录
 * 2、删除
 *    boolean delete():删除文件
 *    void deleteOnExit():在程序退出时删除文件
 *3、判断
 *    boolean exists(): 文件是否存在
 *    boolean isDirectory():是否是目录 （判断目录和文件之前必须先判断是否存在）
 *    boolean isFile():是否是文件
 *    boolean isAbsolute(): 是否是绝对路径
 *4、获取信息,返回值均为String
 *    getName()：文件名
 *    getParent()：目录
 *    getpath()：路径
 *    getAbsolutePath()：绝对路径
 *    lastModified()：最后一次修改时间
 *    leng(): 文件大小
 **/
public class BasicInfo {
    public static void main(String[] args) throws IOException {
        //createFileTest();
        //根目录
        File[] f=File.listRoots();
        for (File file:f)
            System.out.println(file);

        File file=new File("/Users/wangaijun/work");
        //返回当前目录下所有文件名，包括隐藏文件
        String[] names=file.list();
        for (String name: names)
            System.out.println(name);

        File[] files=file.listFiles();
        for (File filea:files) {
            System.out.println(filea.getName()+"...."+filea.length());

        }
        System.out.println(files[0]);
        System.out.println(files[1]);

        System.out.println("-------------");

        allFiles(file);

    }

    public static void createFileTest() throws IOException {
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/FileTest.txt";
        //创建文件，传入所有路径及文件名
        File file=new File(path);

        String path1="demo/src/main/resources/ResourseForIOStudy/IOStudy/";
        //创建文件，第一个参数是路径，第二个参数是文件名，是变量
        File file1=new File(path1,"path1.txt");

        //打印的是路径
        System.out.println("f1: "+file);

        //File.separator路径分隔符，可以跨平台使用
        File file2=new File("demo"+File.separator+"src"+File.separator+
                "resources"+File.separator+"ResourseForIOStudy"+File.separator
        +"IOStudy");
        System.out.println("file2: "+file2);

        //创建
        boolean c=file.createNewFile();
        System.out.println("create: "+c);

        System.out.println("exists: "+file.exists());

        System.out.println("Parent: "+ file.getParent());
        System.out.println("Path: "+ file.getPath());
        System.out.println("absolutePath: "+ file.getAbsolutePath());
        System.out.println("Name: "+ file.getName());
        System.out.println("Length: "+ file.length());
        System.out.println("LastModify: "+ file.lastModified());

        System.out.println("isFile: "+file.isFile());
        System.out.println("isAbs: "+file.isAbsolute());

        boolean d=file.delete();
        System.out.println("delete: "+d);

    }

    //返回文件夹及子文件夹内所有文件
    public static void allFiles(File file){
        File[] f=file.listFiles();
        for (File file1:f){
            if (file1.isDirectory())
                allFiles(file1);
            else
                System.out.println(file1);
        }
    }
}
