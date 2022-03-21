package Study.IOStudy.inputStream;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MyBufferedInputStream
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/8 下午3:12
 * @Version 1.0
 */
public class MyBufferedInputStream {
    private InputStream inputStream;

    private byte[] bytes=new byte[1024];

    private int pos=0,count=0;

    MyBufferedInputStream(InputStream inputStream){
        this.inputStream=inputStream;
    }

    public int myRead() throws IOException {
        if (count==0) {
            count = inputStream.read(bytes);
            if (count<0)
                return -1;
            pos=0;
            byte b = bytes[pos];
            count--;
            pos++;
            return b&255;
        }
        else if (count>0){
            byte b = bytes[pos];
            count--;
            pos++;
            return b&255;
        }
        return -1;
    }

    public void myClose() throws IOException{
        inputStream.close();
    }
}
