package Study.internetStudy.UDPStudy;

/**
 * @ClassName UDPReceiveStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午1:15
 * @Version 1.0
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP:接收数据
 *
 * 思路：
 * 1、定义socket服务，通常会监听一个端口，其实就是给这个接收的程序定义一个数字标识
 * 2、定义数据包，存储接收到的字节数据，数据包对象中有提取字节数据信息的功能
 * 3、通过socket中receive方法接收数据
 * 4、通过数据包中特有功能，取出数据
 * 5、关闭资源
 * */
public class UDPReceiveStudy {
    public static void main(String[] args) throws Exception {

        //创建socket，端口为10000
        DatagramSocket ds = new DatagramSocket(10000);

        while (true) {

            //定义数据包，存储数据
            byte[] buf = new byte[1024];

            DatagramPacket dp = new DatagramPacket(buf, buf.length);

            //receive方法，阻塞方法，没数据就等待
            ds.receive(dp);

            //通过数据包中的方法，获取数据
            String ip = dp.getAddress().getHostAddress();

            String data = new String(dp.getData(), 0, dp.getLength());

            int port = dp.getPort();

            System.out.println(ip + ": :" + data + ":: " + port);


        }
        //关闭资源
        //ds.close();
    }
}
