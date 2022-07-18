package MsbStudy.HighLevel.wangluobiancheng;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class BasicInfo {
/*
* 网络通信，电脑A给电脑B上的微信发消息，通过ip定位电脑B，通过端口号，定位电脑B上的唯一的应用程序微信通过 ip+端口号通信
* */
public static void main(String[] args) throws UnknownHostException {
    testInetAddress();
    testInetSocketAddress();
}
    //    InetAddress是包装ip的，通过名字
public static void testInetAddress() throws UnknownHostException {

    InetAddress i1=InetAddress.getByName("10.252.216.127"); //通过ip封装
    InetAddress i2=InetAddress.getByName("127.0.0.1");//通过ip封装
    InetAddress i3=InetAddress.getByName("www.58.com");//通过域名封装
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(i3);
    System.out.println(i3.getHostAddress());
    System.out.println(i3.getHostName());
}
    //    InetSocketAddress封装端口号的
public static void testInetSocketAddress(){
    InetSocketAddress i=new InetSocketAddress("10.252.216.127",8888);
    System.out.println(i);
    System.out.println(i.getHostName());
    System.out.println(i.getHostString());
}
/*
* 套接字：应用层链接运输层的桥梁，通过套接字获取传输协议 TCP UDP
* */
}
