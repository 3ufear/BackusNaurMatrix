import MatrixComponents.Matrix;
import MatrixComponents.MatrixElement;
import MatrixComponents.MatrixIterator;
import RevPolishNotation.Calculator;
import StreamProcessor.MatrixFromStreamCreator;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by phil on 10/5/2015.
 */
public class Main {
    public static void main(String[] args) {
        MatrixFromStreamCreator creator = new MatrixFromStreamCreator();
        try {
            creator.readInputStream();
            Matrix matrix = creator.getMatrix();
            Calculator calc = new Calculator();
            calc.processMatrix(matrix);

            Iterator<MatrixElement> it = matrix.iterator();
            while(it.hasNext()) {
               System.out.println(it.next().toSpecialFormat());
                //System.out.println(it.next().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
