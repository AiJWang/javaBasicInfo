package Study.GUIStudy;

/**
 * @ClassName MouseAndkeyEvent
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/11 下午10:03
 * @Version 1.0
 */

import java.awt.*;
import java.awt.event.*;

/**
 * 鼠标和键盘等共性事件
 * */
public class MouseAndkeyEvent {
    private Frame frame;
    private Button bu;
    private TextField tf;

    MouseAndkeyEvent(){
        init();
    }
    public void init(){
        frame=new Frame("my frame");

        //对frame进行基本设置
        frame.setBounds(300,100,600,500);

        frame.setLayout(new FlowLayout());

        bu=new Button("my button");

        //添加文本输入框
        tf=new TextField(10);

        frame.add(tf);

        //将组件添加等到frame
        frame.add(bu);

        //加载窗体事件
        myEvent();

        //显示窗体
        frame.setVisible(true);
    }

    private void myEvent(){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //让button按钮具备退出功能，需要去Button组件中查询，每个组件的都得去自己组件自己查询

        bu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮退出");
                //System.exit(0);
            }
        });

        //添加鼠标事件
        bu.addMouseListener(new MouseAdapter() {
            int count=0;
            @Override
            public void mouseEntered(MouseEvent e) {

                System.out.println("鼠标进入"+count++);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==2)
                {
                    System.out.println("双击了老铁");
                }
            }
        });

        //键盘事件

        bu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //打印键盘码及ASCII
                System.out.println(e.getKeyChar()+"..."+e.getKeyCode());
            }
        });

        //输入框键盘事件,只允许输入数字
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code=e.getKeyCode();
                if (!(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9)){
                    System.out.println("非法字符："+e.getKeyChar());
                    //非法字符无法输入进去
                    e.consume();
                    System.out.println("consume");
                }
            }
        });
    }
}
