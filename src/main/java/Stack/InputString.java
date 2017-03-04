package Stack;

/**
 * Created by anton on 2/25/17.
 */
public class InputString {

    public String s = "1.0, 3, /  ;";
    //    public String s="-125, +567, +, +56.78, -4.5678, *, -;";
    private int size = s.length();
    private int count = 0;
    private char[] str = s.toCharArray();

    public double getNumber() {
        int integerPart = 0;
        double fractionPart = 0.0;
        int sign = 1;

        if (str[count] == '+') {
            count++;
        }
        if (str[count] == '-') {
            sign = -1;
            count++;
        }

        do {
            integerPart = integerPart * 10 + (int) str[count] - (int) '0';
            count++;
        } while (isDigit(str[count]));

        if (str[count] == ',' || str[count] == ';' || str[count] == ' ') {
            return (integerPart + fractionPart) * sign;
        }

        if (str[count] != '.') {
            throw new StringIndexOutOfBoundsException();
        }

        count++;

        int power = 10;
        do {
            fractionPart = fractionPart + (double) ((int) str[count] - (int) '0') / power;
            power *= 10;
            count++;
        } while (isDigit(str[count]));

        return (integerPart + fractionPart) * sign;
    }

    public char getNextChar() {
        if (count == size - 1)
            throw new StringIndexOutOfBoundsException();
        return str[count + 1];
    }

    public boolean isDigit(char curChar) {
        return (curChar >= '0' && curChar <= '9');
    }

    public void analyzeString() {
        Stack stack = new Stack();
        while (count < size) {
            if (isDigit(str[count]))
                stack.push(getNumber());
            else {
                switch (str[count]) {
                    case '+':
                        if (isDigit(getNextChar()))
                            stack.push(getNumber());
                        else
                            stack.push(stack.pop() + stack.pop());
                        count++;
                        break;
                    case '-':
                        if (isDigit(getNextChar()))
                            stack.push(getNumber());
                        else
                            stack.push(-stack.pop() + stack.pop());
                        count++;
                        break;
                    case '*':
                        stack.push(stack.pop() * stack.pop());
                        count++;
                        break;
                    case '/':
                        stack.push(1 / stack.pop() * stack.pop());
                        count++;
                        break;
                    case ',':
                        count++;
                        break;
                    case ' ':
                        count++;
                        break;
                    case ';':
                        if (stack.getSize() > 0)
                            System.out.println(stack.pop());
                        return;
                    default:
                        throw new StringIndexOutOfBoundsException();
                }
            }
        }
        if (stack.getSize() > 0)
            System.out.println(stack.pop());
        return;
    }
}
