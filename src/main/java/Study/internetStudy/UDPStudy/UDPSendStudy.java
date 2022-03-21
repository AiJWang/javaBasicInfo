package Study.internetStudy.UDPStudy;

/**
 * @ClassName UDPStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午1:08
 * @Version 1.0
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP:
 * 通过UDP发送文字数据
 * 思路：
 * 1、建立UDPSocket服务
 * 2、提供要发送到数据，并封装到数据包
 * 3、通过Socket服务发送功能，发送数据
 * 4、关闭资源
 * */
public class UDPSendStudy {
    public static void main(String[] args) throws Exception {
        //创建socket服务，发送端的端口8888
        DatagramSocket ds=new DatagramSocket(8888);

        //创建数据
        byte[] data="udp studuy".getBytes();

        DatagramPacket dp=new DatagramPacket(data, data.length,
                InetAddress.getByName("192.168.1.102"),10000);

        //发送数据
        ds.send(dp);

        //关闭资源
        ds.close();
    }
}
