package Study.internetStudy.saveFiles;

import java.net.Socket;

/**
 * @ClassName SocketSendFile
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午4:01
 * @Version 1.0
 */

/**
 * 客户端发送文件，服务端接收并保存
 * 定义结束标志，流中加入结束标记s.shutdownOutput();
 *
 * 服务端并发；
 * 服务端有个局限性，当A客户端连接后，被服务端获取，B客户端只能等待
 * */
public class SocketSendFile {
    public static void main(String[] args) throws Exception {
        Socket s=new Socket("192.168.1.102",10007);

    }
}
