package Study.internetStudy.UDPStudy.ChartDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName UDPSendDemo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 下午1:41
 * @Version 1.0
 */
public class UDPSendDemo implements Runnable {

    private DatagramSocket ds;

    UDPSendDemo(DatagramSocket ds){
        this.ds=ds;
    }

    public void run()
    {
        try {
            //读取键盘录入
            BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));

            String line=null;
            while ((line=bufr.readLine())!=null)
            {
                if ("886".equals(line))
                    break;
                byte[] buf=new byte[1024];

                buf=line.getBytes();

                DatagramPacket dp=new DatagramPacket(buf,buf.length,
                        InetAddress.getByName("192.168.1.102"),10002);

                ds.send(dp);
            }

        }catch (Exception e){
            throw new RuntimeException("发送失败");
        }
    }
}
