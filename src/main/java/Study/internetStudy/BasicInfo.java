package Study.internetStudy;

/**
 * @ClassName BasicInfo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 上午10:35
 * @Version 1.0
 */

import java.net.InetAddress;
import java.util.Arrays;

/**
 * 网络编程：
 * 1、找到对方：用IP
 * 2、数据要求发送到对方指定的应用程序上，比如qq，微信
 * 为了标识这些应用程序，所以网络程序都用数字进行标识，这些数字就是端口
 * 3、定义通讯规则，就是协议，通用协议TCP／IP
 * 本地地址：127.0.0.1
 *
 * TCP／UDP
 * UDP：无连接，不需要建立连接，每个数据包在64k以内，不可靠，速度快
 *
 * TCP：面向连接，大量数据传输，可靠协议，效率稍低
 *
 * 网络编程就是socket编程
 * */
public class BasicInfo {
    public static void main(String[] args) throws Exception {
        //当前主机ip及名称
        InetAddress i=InetAddress.getLocalHost();
        System.out.println(i.toString());
        //获取ip地址
        System.out.println(i.getHostAddress());
        //获取主机名称
        System.out.println(i.getHostName());

        //获取任意主机地址
        InetAddress[] i1=InetAddress.getAllByName("www.baidu.com");
        System.out.println(Arrays.toString(i1));
        System.out.println(i1[0].getHostAddress());
        System.out.println(i1[0].getHostName());
    }
}
