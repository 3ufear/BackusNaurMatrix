package Matrix;

/**
 * Created by phil on 10/5/2015.
 */
public class MatrixElement {
    private String expression;
    private double result;
    private boolean isComplete;

    public MatrixElement() {

    }

    public MatrixElement(String expression) {
        this.expression = expression;
        isComplete = false;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setComplete() {
        isComplete = true;
    }

    public boolean isComlete() {
        return isComplete;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(expression).append(" = ");
        if (isComplete) {
            sb.append(result);
        } else {
            sb.append("?");
        }
        return sb.toString();
    }
}
