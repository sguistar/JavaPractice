import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

public class SimpleCalculator extends JFrame
{
    JComboBox<String> symbolBox;
    JButton equal;
    static JTextField num1;
    static JTextField num2;
    JLabel plus;
    static JTextField sum;
    public SimpleCalculator()
    {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        num1 = new JTextField(10);
        String []symbol = {"Plus", "Minus", "Multiply", "Divide"};
        symbolBox = new JComboBox<>(symbol);
        num2 = new JTextField(10);
        equal = new JButton("=");
        sum = new JTextField(20);
        equal.addActionListener(l -> analyzeData(String.valueOf(symbolBox.getSelectedItem())));
        add(num1);
        add(symbolBox);
        add(num2);
        add(equal);
        add(sum);
        setSize(450, 100);
        setVisible(true);
    }

    public void analyzeData(String type)
    {
        double result = switch (type)
        {
            case "Plus" -> getSum();
            case "Minus" -> getVariation();
            case "Multiply" -> getMul();
            case "Divide" -> getDiv();
            default -> 0.0;
        };
        sum.setText(String.valueOf(result));
    }
    public double getSum()
    {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());
        return a + b;
    }

    public double getVariation()
    {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());
        return a - b;
    }

    public double getMul()
    {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());
        return a * b;
    }

    public double getDiv()
    {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());
        if (b == 0)
        {
            JOptionPane.showMessageDialog(this, "除数不能为0", "错误", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(SimpleCalculator::new);
    }
}
