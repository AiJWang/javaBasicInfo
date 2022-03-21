package Study.IOStudy.guanDaoLiu;

import java.io.PipedOutputStream;

/**
 * @ClassName GuanDaoWrite
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/9 下午11:37
 * @Version 1.0
 */
public class GuanDaoWrite implements Runnable {
    PipedOutputStream po;
    GuanDaoWrite(PipedOutputStream po)
    {
        this.po=po;
    }
    public void run(){
        try{
            po.write("nihao".getBytes());
            po.close();
        }catch (Exception e){
            System.out.println(e.getMessage());

        }

    }

}
