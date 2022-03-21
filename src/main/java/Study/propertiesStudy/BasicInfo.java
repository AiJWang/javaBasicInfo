package Study.propertiesStudy;

/**
 * @ClassName BasicInfo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/9 下午8:12
 * @Version 1.0
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * properties是hashtable的子类，具有map集合特点，存储的是键值对
 *
 *是集合中和IO技术结合的集合容器
 * 特点：用于键值对形式的配置文件
 *
 * 加载文时，需要固定格式 键=值
 *
 * 配置文件格式： .property 或者是xml文件
 * */
public class BasicInfo {
    public static void main(String[] args) throws IOException {
        setAndGet();
        getInfo();
        coutTime();
    }

    public static void setAndGet(){
        Properties peoperties=new Properties();

        //设置properties
        peoperties.setProperty("zhangsan","30");
        peoperties.setProperty("lisi","40");

        System.out.println(peoperties);

        //获取properties
        String value=peoperties.getProperty("zhangsan");
        System.out.println("value: "+value);

        //获取所有key值
        Set<String> keys=peoperties.stringPropertyNames();
        for (String s:keys)
        {
            System.out.println(s);
        }
    }
    //将文件中键值数据存入到集合中进行操作
    public static void getInfo() throws IOException {
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/peopertiesStudy.txt";
        Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream(path);
        //将文件中数据存入到properties中
        properties.load(fileInputStream);
        System.out.println(properties);
        //修改配置文件
        properties.setProperty("wangwu","15");
        //将结果存到文件中
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        properties.store(fileOutputStream,"这是个备注");

        fileInputStream.close();
        fileOutputStream.close();
    }
    //实现一个程序计数功能，每次调用次程序，次数+1
    public static void coutTime() throws IOException{
        File file=new File("demo/src/main/resources/ResourseForIOStudy/" +
                "IOStudy/countTime.txt");

        if (!file.exists())
            file.createNewFile();

        Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream(file);

        properties.load(fileInputStream);

        int count=0;

        String value=properties.getProperty("count");
        if (null!=value)
            count=Integer.parseInt(value);
        count++;
        if (count>=5)
        {
            System.out.println("已达最大次数");
            return;
        }
        properties.setProperty("count",count+"");

        FileOutputStream fileOutputStream=new FileOutputStream(file);
        properties.store(fileOutputStream,"计数器");

        fileInputStream.close();
        fileOutputStream.close();
    }
}
