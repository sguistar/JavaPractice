public class Fraction
{
    private final int a;
    private final int b;

    private int gcd(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        return gcd(b, a % b);
    }

    public Fraction()
    {
        this(1, 1);
    }

    public Fraction(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public String Plus(Fraction other)
    {
        return new Fraction(a * other.b + b * other.a, b * other.b).toString();
    }

    @Override
    public String toString()
    {
        double factor = gcd(a, b);
        if (a == 0 && b != 0)
        {
            return "0";
        }
        return a / factor + "/" + b / factor;
    }
}
