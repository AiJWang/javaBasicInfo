package Study.IOStudy.guanDaoLiu;

/**
 * @ClassName GuanDaoLiu
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/9 下午11:26
 * @Version 1.0
 */

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**管道流：涉及到多线程
 * PipedInputStream; PipedOutputStream
 * */
public class GuanDaoLiu {
    public static void main(String[] args) throws IOException {
        PipedOutputStream po=new PipedOutputStream();
        PipedInputStream pi=new PipedInputStream();
        //管道连接
        pi.connect(po);

        GuanDaoWrite gw=new GuanDaoWrite(po);
        GuanDaoRead gr=new GuanDaoRead(pi);

        new Thread(gw).start();
        new Thread(gr).start();
    }
}
