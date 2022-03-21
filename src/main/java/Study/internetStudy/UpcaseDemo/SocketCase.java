package Study.internetStudy.UpcaseDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @ClassName SocketCase
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午3:29
 * @Version 1.0
 */

/**
 * 客户端想服务端发送文本数据，并且可以一直发，知道over结束
 * 服务端返回数据的大写，
 * */
public class SocketCase {
    public static void main(String[] args) throws Exception {
        Socket s=new Socket("192.168.1.102",10006);

        BufferedReader bufr=new BufferedReader(
                new InputStreamReader(System.in));

        BufferedWriter buout=new BufferedWriter(
                new OutputStreamWriter(s.getOutputStream()));

        BufferedReader buin=new BufferedReader(new
                InputStreamReader(s.getInputStream()));

        String line=null;

        while ((line=bufr.readLine())!=null){
            if (line.equals("over"))
                break;
            buout.write(line);
            //因为服务端读数据的方法是readline，此方法必须读到换行符才表明读取结束，但是写入的时候，
            // 写的是换行符之前的内容，所以需要收到newline一下，并且写到缓冲区里去了，需要刷新一下
            buout.newLine();
            buout.flush();

            String str=buin.readLine();
            System.out.println("fromServer: "+str);
        }
        bufr.close();
        s.close();
    }
}
