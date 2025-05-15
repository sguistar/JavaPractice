public class Coconut extends Circle
{
    public Circle c1 = new Circle(3);
    public Circle c2 = new Circle(2);
    public double area = Math.abs(c1.getArea() - c2.getArea());

    public Coconut()
    {
        super();
    }

    public Coconut(double r)
    {
        super(r);
    }


}
