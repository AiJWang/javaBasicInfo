package Study.GUIStudy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName FrameDemo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/4/11 下午9:53
 * @Version 1.0
 */
public class FrameDemo {
    private Frame frame;
    private Button bu;

    FrameDemo(){
        init();
    }
    public void init(){
        frame=new Frame("my frame");

        //对frame进行基本设置
        frame.setBounds(300,100,600,500);

        frame.setLayout(new FlowLayout());

        bu=new Button("my button");

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
                System.exit(0);
            }
        });
    }
}
