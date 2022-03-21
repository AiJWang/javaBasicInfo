package Study.internetStudy.SocketAndSocketServer;

/**
 * @ClassName SocketAndServer
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午2:14
 * @Version 1.0
 */

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端向server发送数据，server向客户端返回数据
 *
 * 客户端：
 * 1、建立socket服务，制定主机和端口
 * 2、获取socket输出流，将数据写入流中
 * 3、获取socket输入流，将服务端反馈的数据收到，并打印
 * 4、关闭资源
 * */
public class SocketAndReceive {
    public static void main(String[] args) throws Exception {
        Socket s=new Socket("192.168.1.102",10005);

        OutputStream out=s.getOutputStream();
        out.write("向服务端发送数据，一会读回来。。。".getBytes());

        InputStream in=s.getInputStream();

        byte[] buf=new byte[1024];

        int len=in.read(buf);

        System.out.println(new String(buf,0,len));

        s.close();
    }
}
