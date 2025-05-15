public class Triangle
{
    protected double a, b, c;

    protected boolean IsLegal()
    {
        return a + b > c || a + b < c || a + c < b;
    }

    public Triangle()
    {
        a = 1.0;
        b = 1.0;
        c = 1.0;
    }

    public Triangle(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA()
    {
        this.a = a;
    }

    public void setB()
    {
        this.b = b;
    }

    public void setC()
    {
        this.c = c;
    }

    public double getA()
    {
        return a;
    }

    public double getB()
    {
        return b;
    }

    public double getC()
    {
        return c;
    }

    public double getArea()
    {
        double p = (a + b + c) / 2.0;
        if (IsLegal())
        {
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return -1;
    }

    public double getPerimeter()
    {
        if (IsLegal())
        {
            return a + b + c;
        }
        return -1;
    }
}