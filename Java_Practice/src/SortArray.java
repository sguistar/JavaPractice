public class SortArray
{
    double[] array;//数组实例

    public SortArray(int[] other_arrays)//重载构造方法,使该类能够接受int类型的数组
    {
        this.array = new double[other_arrays.length];
        for (int i = 0; i < other_arrays.length; i++)
        {
            this.array[i] = other_arrays[i];
        }
    }

    public SortArray(double[] other_arrays)//使实例指向被传入的数组
    {
        this.array = other_arrays;
    }

    public void SelectionSort()
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[i] > array[j])
                {
                    double t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }
        }
    }

    public void BubbleSort()
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 1; j < array.length - i; j++)
            {
                if (array[j - 1] > array[j])
                {
                    double temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void InsertionSort()
    {
        for (int j = 1; j < array.length; j++)
        {
            double key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key)
            {
                array[i + 1] = array[i];
                i -= 1;
            }
            array[i + 1] = key;
        }
    }

    public void ShellSort()
    {
        int d, i, j;
        double temp;
        int length = array.length;
        for (d = length / 2; d >= 1; d /= 2)
        {
            for (i = d; i < length; i++)
            {
                temp = array[i];
                for (j = i - d; j >= 0 && temp <= array[j]; j -= d)
                {
                    array[j + d] = array[j];
                }
                array[j + d] = temp;
            }
        }
    }

}
