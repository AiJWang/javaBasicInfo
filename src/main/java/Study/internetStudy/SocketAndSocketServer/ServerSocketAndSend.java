package Study.internetStudy.SocketAndSocketServer;

/**
 * @ClassName ServerSocketAndSend
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午2:19
 * @Version 1.0
 */

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接收客户端数据，并向客户端返回数据
 * */
public class ServerSocketAndSend {
    public static void main(String[] args) throws Exception {
        ServerSocket ss=new ServerSocket(10005);

        Socket s=ss.accept();

        InputStream in=s.getInputStream();
        OutputStream out=s.getOutputStream();

        String ip=s.getInetAddress().getHostAddress();
        System.out.println(ip+"....");

        byte[] buf=new byte[1024];

        int len=in.read(buf);

        System.out.println(new String(buf,0,len));

        out.write("这是服务端返回的数据，客户端可要接住了...".getBytes());
    }
}
