package Study.GUIStudy;

import java.awt.*;

/**
 * @ClassName CaiDanStudy
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/12 上午9:58
 * @Version 1.0
 */
public class CaiDanStudy {

    CaiDanStudy(){
        init();
    }

    private Frame f;
    private MenuBar mb;
    private Menu m;
    private MenuItem mi,closeItem;

    public void init(){
        f=new Frame("Menu");
        f.setBounds(300,100,500,100);
        f.setLayout(new FlowLayout());

        mb=new MenuBar();

        m=new Menu("菜单");

        mi=new MenuItem("子菜单");

        closeItem=new MenuItem("quit");

        m.add(mi);
        m.add(closeItem);

        mb.add(m);
        mb.setName("test");

        f.setMenuBar(mb);

        f.setVisible(true);
    }
}
