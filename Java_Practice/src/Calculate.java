import java.util.Scanner;

public class Calculate
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        //int []nums = new int[n];
        input.close();

        double sum = 0.0;
        for (int k = 1; k <= n; k++)
        {
            sum += (double) (2 * k - 1) / (2 * k + 1);
        }
        String res = String.format("%.3f", sum);
        System.out.println("该数列前n项的和为: " + res);
    }
}
