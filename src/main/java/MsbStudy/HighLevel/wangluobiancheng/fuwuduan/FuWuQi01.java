package MsbStudy.HighLevel.wangluobiancheng.fuwuduan;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FuWuQi01 {
    public static void main(String[] args) throws IOException {
        //创建套接字，因为服务器知道自己的ip，所以设置一个端口就行了
        ServerSocket s=new ServerSocket(9999);
        //一直等待客户端信息
        Socket socket=s.accept();//这是个阻塞方法，接收到数据后，程序才向下执行
        //accept方法返回值是一个socket，这个socket是客户端的socket
        //开始操作流
        InputStream i= socket.getInputStream();
        DataInputStream da=new DataInputStream(i);
        //读取数据
        String a=da.readUTF();
        System.out.println("客户端发来的数据："+a);
        //向客户端回数据
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("我收到了你的数据");
        //关闭流
        dataOutputStream.close();
        outputStream.close();
        da.close();
        i.close();
        s.close();
        socket.close();
    }
}
