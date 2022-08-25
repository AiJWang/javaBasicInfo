package MsbStudy.HighLevel.wangluobiancheng.kehuduan;

import MsbStudy.HighLevel.wangluobiancheng.Person;
import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class KeHuDuan01 {
    public static void main(String[] args) throws Exception {
        //创建套接字，绑定ip和端口号
        Socket s = new Socket("10.252.216.127", 9999);
        //创建输出流，发给服务端的
        OutputStream out=s.getOutputStream();

        //OutputStream本身可以向外发送数据了，但是没法发送字符串，所以又包了一层DataOutputStream
        ObjectOutputStream o=new ObjectOutputStream(out);
        //做一个用户登录的场景
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName=sc.nextLine();
        System.out.println("请输入密码");
        String pwd=sc.nextLine();
        Person p=new Person();
        p.setUsrName(userName);
        p.setPwd(pwd);

        o.writeObject(p);

        //接收服务器返回的数据
        InputStream inputStream = s.getInputStream();
        DataInputStream dataInputStream=new DataInputStream(inputStream);
        boolean serverWord=dataInputStream.readBoolean();
        if (serverWord){
            System.out.println("登录成功");
        }else {
            System.out.println("登陆失败");
        }
        System.out.println("客户端回的消息："+serverWord);
        //关闭流
        dataInputStream.close();
        inputStream.close();
        o.close();
        out.close();
        s.close();
    }
}
