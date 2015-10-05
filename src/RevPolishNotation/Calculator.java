package RevPolishNotation;

import MatrixComponents.Matrix;
import MatrixComponents.MatrixElement;
import MatrixComponents.MatrixIterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by phil on 10/5/2015.
 */
public class Calculator {
    Matrix matrix = null;

    private boolean isDelim(char c) {
        return c == ' ';
    }

    private boolean isRefToAnotherItem(String operand) {
        boolean result = false;
        if (Character.isUpperCase(operand.charAt(0))) {
            int i = 1;
            result = true;
            while (result && i < operand.length()) {
                if (!Character.isDigit(operand.charAt(i))) {
                    result = false;
                }
                i++;
            }
        }
         return result;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '*' || c == '/' || c == '%';
    }

    private void processOperator(LinkedList<String> st, char op) {
        double r = Double.parseDouble(st.removeLast());
        double l = Double.parseDouble(st.removeLast());
        Double res;
        switch (op) {
            case '+':
                res = l + r;
                st.add(res.toString());
                break;
            case '-':
                res = l - r;
                st.add(res.toString());
                break;
            case '*':
                res = l * r;
                st.add(res.toString());
                break;
            case '/':
                res = l/r;
                st.add(res.toString());
                break;
        }
    }
    private boolean eval(MatrixElement el, HashSet<String> set) {
        if (set == null) {
            set = new HashSet<String>();
        }
        boolean is_Ok = true;
        String expr = el.getExpression();
        LinkedList<String> st = new LinkedList<String>();
        LinkedList<Character> op = new LinkedList<Character>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (isDelim(c))
                continue;
            else if (isOperator(c)) {
                op.add(c);
            } else if (c == '-' && (i+1) == expr.length()) {
                op.add(c);
            }else if (c == '-' && (i+1) < expr.length() && isDelim(expr.charAt(i+1))) {
                op.add(c);
            } else {
                String operand = "";
                while (i < expr.length() && !isDelim(expr.charAt(i)))
                    operand += expr.charAt(i++);
                --i;
                if (isRefToAnotherItem(operand)) {
                    int index = getFirstIndex(operand);
                    int j = getSecondIndex(operand);
                    if (matrix.isValidIndexes(index, j)) {
                        MatrixElement me = matrix.getMatrixElement(index, j);
                        if (me.isComlete()) {
                            st.add(me.getResult().toString());
                        } else {
                            if (!set.add(operand)) {
                                System.err.println("loop with operators: " + set + ". Dependence on " + operand);
                                el.setError();
                                is_Ok = false;
                            } else {
                                if (eval(me,set))
                                     st.add(me.getResult().toString());
                                else {
                                    el.setError();
                                    is_Ok = false;
                                }
                            }
                        }
                    } else {
                        System.err.println("Not valid Index of " + operand);
                        is_Ok = false;
                        el.setError();
                    }
                } else {
                    st.add(operand);
                }
            }
        }
        if (is_Ok) {
            while (!op.isEmpty())
                processOperator(st, op.removeLast());
            el.setResult(Double.valueOf(st.get(0)));
            el.setComplete();
        }
        return is_Ok;
    }

    private int getFirstIndex(String operator) {
        return operator.charAt(0) - 'A';
    }

    private int getSecondIndex(String operator) {
        return Integer.parseInt(operator.substring(1, operator.length()));
    }


    public void processMatrix(Matrix matrix) {
        this.matrix = matrix;
        Iterator<MatrixElement> it = matrix.iterator();
        MatrixElement el = null;
        while(it.hasNext()) {
            el = it.next();

            if (!el.isComlete() && !el.isErrorExpression())
                 eval(el, null);
        }
    }
}
