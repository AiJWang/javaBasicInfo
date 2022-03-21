package Study.internetStudy.UDPStudy.ChartDemo;

/**
 * @ClassName ChartDemo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午1:40
 * @Version 1.0
 */

import java.net.DatagramSocket;

/**
 * 聊天程序，多线程，一个收，一个发
 * */
public class ChartDemo {
    public static void main(String[] args) throws Exception {
        DatagramSocket sendSocket=new DatagramSocket();
        DatagramSocket receiveSocket=new DatagramSocket(10002);

        new Thread(new ReceiveDemo(receiveSocket)).start();
        new Thread(new UDPSendDemo(sendSocket)).start();
    }
}
