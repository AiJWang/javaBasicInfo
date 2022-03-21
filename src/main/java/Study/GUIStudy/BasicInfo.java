package Study.GUIStudy;

/**
 * @ClassName BasicInfo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/11 下午7:51
 * @Version 1.0
 */

import java.awt.*;

/**
 * GUI 提供的对象都在java.Awt 和 Swing中
 * 用Swing就行，它是在Awt基础上的
 * Component
 *   |-- Button（按钮）
 *   |-- Lable （标签）
 *   |-- Checkbox(勾选框)
 *   |-- TextComponent
 *       |--TextArea
 *       |--TestField
 *   |--Container：容器
 *       |--Window
 *           |--Frame：窗体
 *           |--Dialog:对话框
 *               |--FileDialog
 *       |--Panel:面板
 * */

/**
 * 创建图形化洁面
 * 1、创建frame窗体
 * 2、对窗体进行基本设置
 *     大小，位置，布局等
 * 3、定义组件
 * 4、将定义的组件通过add方法添加到窗体中
 * 5、让窗体显示，通过setVisible(true)方法
 *
 * 事件监听机制：点击关闭按钮，关闭弹窗类似
 * 事件监听机制的特点：
 * 1、事件源：awt或者Swing包中图形界面组件
 * 2、事件：每一个事件源都有自己特有的对应事件和共性事件
 * 3、监听器：将可以触发某一个事件的动作都已经封装到了监听器中
 * 4、事件处理方式：定义在监听器中
 *
 * 1、2、3在java这种都已经定义好了，开发可以做的只是事件处理方式
 * */
public class BasicInfo {
    public static void main(String[] args) {
        //showFrame();
        //closeFrame();
        //FrameDemo fd=new FrameDemo();
        //鼠标键盘等公共组件
       // MouseAndkeyEvent mk=new MouseAndkeyEvent();
        //菜单
        new CaiDanStudy();
    }
    public static void showFrame(){
        Frame f=new Frame("my frame");

        //设置长宽，第一个参数是横坐标，第二个参数是纵坐标，都是这样
        f.setSize(500,400);
        //距离屏幕横坐标300，纵坐标200
        f.setLocation(300,200);

        //设置布局 （流式布局）
        f.setLayout(new FlowLayout());
        //添加按钮
        Button b=new Button("关闭");
        f.add(b);
        //是否可见
        f.setVisible(true);

        System.out.println("hello, world");
    }
    //关闭弹窗
    public static void closeFrame(){
        Frame f=new Frame("my frame");

        //设置长宽，第一个参数是横坐标，第二个参数是纵坐标，都是这样
        f.setSize(500,400);
        //距离屏幕横坐标300，纵坐标200
        f.setLocation(300,200);

        //设置布局 （流式布局）
        f.setLayout(new FlowLayout());
        //添加按钮
        Button b=new Button("关闭了吗");
        f.add(b);

        //添加监听器,参数为 WindowListener,WindowAdapter是其子类，一般用这个
        f.addWindowListener(new WindowListenStudy());
        //是否可见
        f.setVisible(true);



        System.out.println("hello, world");
    }

}
