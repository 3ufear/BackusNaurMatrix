package MatrixComponents;

/**
 * Created by phil on 10/5/2015.
 */
public class MatrixElement {
    private String expression;
    private double result;
    private boolean isComplete = false;
    private boolean isErrorExpression = false;

    public MatrixElement() {

    }

    public MatrixElement(String expression) {
        this.expression = expression;
        isComplete = false;
        isErrorExpression = false;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
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

    public Double getResult() {
        return result;
    }

    public void setError() {
        isErrorExpression = true;
    }

    public boolean isErrorExpression() {
        return isErrorExpression;
    }

    public String toSpecialFormat() {
        if (isComplete)
         return String.format("%.5f", result);
        else
            return "?";
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
