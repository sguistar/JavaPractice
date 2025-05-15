import java.util.ArrayList;
import java.util.Collections;

public class Rectangle extends Shape
{
    protected double a, b;

    protected boolean IsSquare()
    {
        return a == b;
    }

    protected double GetRandomSideA()
    {
        return Math.random() * 100 + 1;
    }

    protected double GetRandomSideB()
    {
        return Math.random() * 100 + 1;
    }

    protected double GetRandomArea()
    {
        return GetRandomSideA() * GetRandomSideB();
    }

    public Rectangle()
    {
        this(1.0, 1.0);
    }

    public Rectangle(double a, double b)
    {
        this.a = a;
        this.b = b;
    }

    public double getA()
    {
        return a;
    }

    public double getB()
    {
        return b;
    }

    public void setA(double a)
    {
        this.a = a;
    }

    public void setB(double b)
    {
        this.b = b;
    }

    public double getArea()
    {
        return a * b;
    }

    public double getPerimeter()
    {
        return 2 * (a + b);
    }

    public double CompareAreas(Rectangle a, Rectangle b)
    {
        // return the largest one between Rectangle A and Rectangle B.
        double areaA = a.getArea();
        double areaB = b.getArea();
        return Math.max(areaA, areaB);
    }

    public void SortedAreas(Rectangle a, int number)
    {
        ArrayList<Double> areas = new ArrayList<>(number);
        for (int i = 1; i <= number; i++)
        {
            double area = a.GetRandomArea();
            areas.add(area);
        }
        areas.sort(Collections.reverseOrder());
        for (int j = 1; j <= number; j++)
        {
            System.out.println("第" + j + "大的矩形:" + a.GetRandomSideA() + "*" + a.GetRandomSideB() + "," + "面积为:" + areas.get(j));
        }
    }
}
