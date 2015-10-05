package RevPolishNotation;

import java.util.LinkedList;

/**
 * Created by phil on 10/5/2015.
 */
public class Calculator {
    private boolean isDelim(char c) { // тру если пробел
        return c == ' ';
    }
    private boolean isOperator(char c) { // возвращ€ем тру если один из символов ниже
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }
    private int priority(char op) {
        switch (op) { // при + или - возврат 1, при * / % 2 иначе -1
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }
    private void processOperator(LinkedList<Double> st, char op) {
        double r = st.removeLast();
        double l = st.removeLast();
        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
        }
    }
    public Double eval(String s) {
        LinkedList<Double> st = new LinkedList<Double>();
        LinkedList<Character> op = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            else if (isOperator(c)) {
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    operand += s.charAt(i++);
                --i;
                st.add(Double.parseDouble(operand));
            }
        }

        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);  // возврат результата
    }
}
