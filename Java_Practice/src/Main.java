import java.util.Random;

public class Main
{
    public static void SelectSort(Shape[] s)
    {
        for (int i = 0; i < s.length; i++)
        {
            int min_index = i;
            for (int j = i + 1; j < s.length; j++)
            {
                if (s[j].getArea() < s[min_index].getArea())
                {
                    min_index = j;
                }
            }
            Shape temp = s[i];
            s[i] = s[min_index];
            s[min_index] = temp;
        }
    }

    public static void PrintArray(Shape[] s)
    {
        for (int i = 0; i < s.length; i++)
        {
            if (s[i] instanceof Circle)
            {
                System.out.println("第" + (i + 1) + "个圆的面积为：" + s[i].getArea());
            }
            else
            {
                System.out.println("第" + (i + 1) + "个矩形的面积为：" + s[i].getArea());
            }
        }
    }

    public static void main(String[] args)
    {
        Shape[] s = new Shape[100];
        Rectangle[] r = new Rectangle[100];
        Circle[] c = new Circle[100];
        Random rd = new Random();
        for (int i = 0; i < s.length; i++)
        {
            double a = rd.nextDouble(10.0) + 1.0;
            double b = rd.nextDouble(10.0) + 1.0;
            double radius = rd.nextDouble(10.0) + 1.0;
            r[i] = new Rectangle(a, b);
            c[i] = new Circle(radius);
            if (rd.nextInt(2) == 0)
            {
                s[i] = new Circle(radius);
            }
            else
            {
                s[i] = new Rectangle(a, b);
            }
        }

        PrintArray(s);
        System.out.println("-------------------------------------------------------------------------------------------");
        SelectSort(s);
        PrintArray(s);
    }
}