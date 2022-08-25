package MsbStudy.HighLevel.wangluobiancheng.fuwuduan;

import MsbStudy.HighLevel.wangluobiancheng.Person;

import java.io.*;
import java.net.Socket;

public class FuWuQi02 implements Runnable{
    Socket socket;
    public FuWuQi02(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run(){
        DataOutputStream dataOutputStream=null;
        OutputStream outputStream=null;
        ObjectInputStream oi=null;
        InputStream i=null;
        try{
            i= socket.getInputStream();
            //读取数据
            oi=new ObjectInputStream(i);
            Person p=(Person) oi.readObject();
            //向客户端回数据
            outputStream = socket.getOutputStream();
            dataOutputStream=new DataOutputStream(outputStream);
            dataOutputStream.writeBoolean(p.getUsrName().equals("lili") && p.getPwd().equals("123"));
        }catch (Exception e){
            System.out.println(e);
        }finally {
            //关闭流
            try {
                if (null!=dataOutputStream){
                    dataOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null!=outputStream)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null!=oi)
                    oi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null!=i)
                 i.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
