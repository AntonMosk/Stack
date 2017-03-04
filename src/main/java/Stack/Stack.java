package Stack;

public class Stack {
    private double[] arr;
    private int size;
    private int MAX_SIZE = 100;

    public Stack() {
        arr = new double[MAX_SIZE];
        size = 0;
    }

    public void push(double number) {
        if (size == MAX_SIZE)
            throw new IndexOutOfBoundsException();
        arr[size++] = number;
    }

    public double pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return arr[--size];
    }

    public String toString() {
        if (size == 0) {
            return "{ }";
        }
        String s = "{ ";
        for (int i = size - 1; i > 0; i--) {
            s += arr[i] + ", ";
        }
        s += arr[0] + " }";
        return s;
    }

    public int getSize() {
        return size;
    }

}
