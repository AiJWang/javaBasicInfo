package Study.internetStudy.UpcaseDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName ServerSocketCase
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午3:38
 * @Version 1.0
 */
public class ServerSocketCase {
    public static void main(String[] args) throws Exception {
        ServerSocket ss=new ServerSocket(10006);

        Socket s=ss.accept();
        String ip=s.getInetAddress().getHostAddress();
        System.out.println(ip+"...connected");

        BufferedReader bufin=new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        BufferedWriter buw=new BufferedWriter(
                new OutputStreamWriter(s.getOutputStream()));

        String line=null;

        while ((line=bufin.readLine())!=null){
            buw.write(line.toUpperCase());
            //原因跟客户端一样
            buw.newLine();
            buw.flush();
        }
        s.close();
        ss.close();
    }
}
