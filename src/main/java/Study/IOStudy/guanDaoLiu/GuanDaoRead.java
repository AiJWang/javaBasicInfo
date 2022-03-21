package Study.IOStudy.guanDaoLiu;

import java.io.PipedInputStream;

/**
 * @ClassName GuanDaoRead
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/9 下午11:33
 * @Version 1.0
 */
public class GuanDaoRead implements Runnable {
    private PipedInputStream pi;
    GuanDaoRead(PipedInputStream pi){
        this.pi=pi;
    }

    public void run(){
        try{
            byte[] b=new byte[1024];
            int len=pi.read(b);
            String s=new String(b,0,len);
            System.out.println(s);
            pi.close();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
