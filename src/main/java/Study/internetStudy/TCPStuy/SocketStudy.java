package Study.internetStudy.TCPStuy;

/**
 * @ClassName Socket
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午1:57
 * @Version 1.0
 */

import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP：
 *     Socket是客户端 serverSocket是服务端
 *
 * 客户端：Socket对象建立时就可以制定连接的主机
 * 因为socket是面向连接的，所以建立socket服务时，就要有服务端存在
 * 服务端是因为获取客户端的socket对象，来区分不同客户端，并且返回消息
 *
 * 步骤：
 * 1、创建socket服务，并制定连接的主机和端口
 * */
public class SocketStudy {
    public static void main(String[] args) throws Exception {
        //创建客户端的socket,制定目的主机和端口
        Socket s=new Socket("192.168.1.102",10004);

        //为了发送数据，需获取socket中的输出流
        OutputStream out=s.getOutputStream();

        out.write("tcp study".getBytes());

        s.close();
    }
}
