package Study.GUIStudy;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName WindowListenStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/11 下午9:37
 * @Version 1.0
 */
public class WindowListenStudy extends WindowAdapter {

    //关闭窗口
    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("windows closed");
        System.exit(0);
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        System.out.println("windows changed");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //处于前端显示状态
        System.out.println("活了");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("打开了");
    }
}
