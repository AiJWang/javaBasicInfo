package Study.internetStudy;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName WebServer
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午4:45
 * @Version 1.0
 */
public class WebServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss=new ServerSocket(10008);
        while (true) {

            Socket s = ss.accept();
            System.out.println(s.getInetAddress().getHostAddress());

            PrintWriter pw = new PrintWriter(s.getOutputStream());

            pw.println("客户端你好");

        }
    }
}
