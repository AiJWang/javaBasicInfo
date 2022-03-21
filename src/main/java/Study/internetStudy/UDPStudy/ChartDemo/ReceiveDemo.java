package Study.internetStudy.UDPStudy.ChartDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @ClassName ReceiveDemo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午1:43
 * @Version 1.0
 */
public class ReceiveDemo implements Runnable {
    private DatagramSocket ds;

    ReceiveDemo(DatagramSocket ds){
        this.ds=ds;
    }

    public void run()
    {
        try{
            while (true){
                byte[] buf=new byte[1024];

                DatagramPacket dp=new DatagramPacket(buf,buf.length);
                ds.receive(dp);

                String ip=dp.getAddress().getHostAddress();
                String data=new String(dp.getData(),0,dp.getLength());

                System.out.println(ip+"::"+data);
            }
        }catch (Exception e){
            throw new  RuntimeException("接收失败");
        }
    }
}
