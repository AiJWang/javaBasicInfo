package MsbStudy.HighLevel.wangluobiancheng.kehuduan;

import java.io.*;
import java.net.Socket;

public class KeHuDuan01 {
    public static void main(String[] args) throws IOException {
        //创建套接字，绑定ip和端口号
        Socket s = new Socket("10.252.216.127", 9999);
        //创建输出流，发给服务端的
        OutputStream out=s.getOutputStream();
        //OutputStream本身可以向外发送数据了，但是没法发送字符串，所以又包了一层DataOutputStream
        DataOutputStream dataOutputStream=new DataOutputStream(out);
        dataOutputStream.writeUTF("你好");
        //接收服务器返回的数据
        InputStream inputStream = s.getInputStream();
        DataInputStream dataInputStream=new DataInputStream(inputStream);
        String serverWord=dataInputStream.readUTF();
        System.out.println("客户端回的消息："+serverWord);
        //关闭流
        dataInputStream.close();
        inputStream.close();
        dataOutputStream.close();
        out.close();
        s.close();
    }
}
