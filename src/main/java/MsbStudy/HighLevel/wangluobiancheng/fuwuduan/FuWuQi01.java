package MsbStudy.HighLevel.wangluobiancheng.fuwuduan;

import MsbStudy.HighLevel.wangluobiancheng.Person;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FuWuQi01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建套接字，因为服务器知道自己的ip，所以设置一个端口就行了
        //因为服务器是一直启动的，所以写个线程，一直跑
        ServerSocket s=new ServerSocket(9999);
        //一直等待客户端信息
        Socket socket=null;//这是个阻塞方法，接收到数据后，程序才向下执行
        //accept方法返回值是一个socket，这个socket是客户端的socket
        //开始操作流
        int n=0;
        while (true){
            socket=s.accept();
            new Thread(new FuWuQi02(socket)).start();
            System.out.println("当前是第"+n+++"个用户： "+s.getInetAddress());
        }

    }
}
