import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Calculator extends JFrame {

    JButton b1, b2;

    public Calculator()
    {
        super("计算器");

        //设置布局管理器为流式布局
        setLayout(new FlowLayout());

        b1 = new JButton("OK1");
        add(b1);

        b2 = new JButton("OK2");
        add(b2);

        Handler h = new Handler();
        b1.addActionListener(h);
        b2.addActionListener(h);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 300);
        setVisible(true);
    }

    //私有内部类，实现事件监听器功能
    private class Handler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1)
            {
                System.out.println("hello");
            }
            else
            {
                System.out.println("goodbye");
            }
        }

    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
    }

}
