import javax.swing.*;

public class Plus
{
    public static void main(String[] args)
    {
        String firstNumber;
        String secondNumber;

        int num1;
        int num2;
        int sum;

        firstNumber = JOptionPane.showInputDialog("Enter first number");
        secondNumber = JOptionPane.showInputDialog("Enter second number");

        num1 = Integer.parseInt(firstNumber);
        num2 = Integer.parseInt(secondNumber);

        sum = num1 + num2;

        JOptionPane.showMessageDialog(null, "The sum is: " + sum, "Result:", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);

    }
}