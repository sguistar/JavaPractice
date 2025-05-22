import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Calculator extends JFrame
{

    public Calculator()
    {
        //设置布局管理器为流式布局
        setLayout(new FlowLayout());

        JButton b1 = new JButton("OK1");
        add(b1);

        JButton b2 = new JButton("OK2");
        add(b2);

        setSize(200, 300);
        setVisible(true);
        setTitle("计算器");
    }

    public static void main(String[] args)
    {
        Calculator c = new Calculator();
    }

}
