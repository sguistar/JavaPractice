public class Complex
{
    protected int a, b;

    public Complex()
    {
        this(1, 1);
    }

    public Complex(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public String Plus(Complex other)
    {
        int real = this.a + other.a;
        int imag = this.b + other.b;
        return new Complex(real, imag).toString();
    }

    public String Minus(Complex other)
    {
        int real = this.a - other.a;
        int imag = this.b - other.b;
        return new Complex(real, imag).toString();
    }

    public String Multiply(Complex other)
    {
        int real = this.a * other.a - this.b * other.b;
        int imag = this.a * other.b + this.b * other.a;
        return new Complex(real, imag).toString();
    }

    //通过覆写toString方法来规范输出
    @Override
    public String toString()
    {
        if (a == 0)
        {
            if (b == 0)
            {
                return "0";
            }
            else if (b == 1)
            {
                return "i";
            }
            else if (b == -1)
            {
                return "-i";
            }
            else
            {
                return b + "i";
            }
        }
        else
        {
            if (b == 0)
            {
                return String.valueOf(a);
            }
            else if (b == 1)
            {
                return a + "+" + "i";
            }
            else if (b == -1)
            {
                return a + "-i";
            }
        }
        return a + (b >= 0 ? "+" : "") + b + "i";


//        @Override
//        public String toString() {
//        if (a == 0 && b == 0) return "0";
//
//        String realPart = (a != 0) ? String.valueOf(a) : "";
//        String imagPart = "";
//
//        if (b != 0) {
//            if (b == 1) imagPart = "i";
//            else if (b == -1) imagPart = "-i";
//            else imagPart = b + "i";
//
//            if (a != 0 && b > 0) imagPart = "+" + imagPart;
//        }
//
//        return realPart + imagPart;
//    }

    }
}

