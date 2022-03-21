package Study.internetStudy.TCPStuy;

/**
 * @ClassName ServerSocketStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午2:06
 * @Version 1.0
 */

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端：
 * 1、建立服务端socket服务，ServerSocket()
 * 2、获取连接过来的客户端对象
 *    通过accept方法，阻塞式
 * 3、客户端如果发过来数据，那么服务端就要使用对应的客户端对象，并获取该对象的读取流，获取发过来的数据
 * 4、关闭服务端（可选，应该是一直开的）
 * */
public class ServerSocketStudy {
    public static void main(String[] args) throws Exception{
        //建立服务端socket 服务,并监听一个端口
        ServerSocket ss=new ServerSocket(10004);

        //通过accept获取客户端对象
        Socket s=ss.accept();

        //通过客户端对象，读取数据
        InputStream in=s.getInputStream();

        String ip=s.getInetAddress().getHostAddress();
        System.out.println(ip+"..");

        byte[] buf=new byte[1024];
        int len=in.read(buf);

        System.out.println(new String(buf,0,len));
    }
}
