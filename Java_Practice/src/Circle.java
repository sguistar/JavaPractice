public class Circle extends Shape
{
    protected double r;

    public Circle()
    {
        this(1.0);
    }

    public Circle(double r)
    {
        this.r = r;
    }

    public double getR()
    {
        return r;
    }

    public void setR(int r)
    {
        this.r = r;
    }

    public double getArea()
    {
        return Math.PI * Math.pow(r, 2);
    }

    public double getPerimeter()
    {
        return 2 * Math.PI * r;
    }

}
