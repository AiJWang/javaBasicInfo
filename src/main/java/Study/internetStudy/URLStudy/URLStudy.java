package Study.internetStudy.URLStudy;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName URLStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/13 上午10:49
 * @Version 1.0
 */

/**
 * 127.0.0.1=localhost 本机地址，在hosts文件中
 *
 * 要是本机hosts文件中配置了 域名及ip的对应关系，当请求一个网址时，就不去DNS解析了，
 * 直接用hosts文件中的
 *
 * */
public class URLStudy {
    public static void main(String[] args) throws Exception {
        URL url=new URL(
        "https://capital-testing7.wecash.net/zfpt/competitor/project/decided/queryMyTask?accessToken=c4076a4714d622daab3ca7ac1eee9484&uid=13A89F5349EE7F46890058ACEDC0C8C1&sessionId=c3b4153ce9d04749925b2e22f064ad08");

        //获取协议名称
        System.out.println("getProtocol: "+url.getProtocol());

        //获取url主机名
        System.out.println("getHost: "+url.getHost());

        //获取URL路径
        System.out.println("getPath: "+url.getPath());

        //获取url文件
        System.out.println("getFile: "+url.getFile());

        //获取url端口
        System.out.println("getPort: "+url.getPort());

        //获取url的查询部
        System.out.println("getQuery: "+url.getQuery());

        //访问该网址，不用写socket了，socket是传输层，现在是应用层
        URLConnection uc=url.openConnection();

        System.out.println(uc);

        //读取内容，跟socket一样
        InputStream in=uc.getInputStream();

        byte[] buf=new byte[1024*1024];

        int len=in.read(buf);

        System.out.println(new String(buf,0,len));

        System.out.println(InetAddress.getByName("capital-testing7.wecash.net" +
                ""));
    }
}
