import RevPolishNotation.Calculator;
import StreamProcessor.MatrixFromStreamCreator;

import java.io.IOException;
import java.util.Iterator;

import Matrix.*;

/**
 * Created by phil on 10/5/2015.
 */
public class Main {
    public static void main(String[] args) {
        MatrixFromStreamCreator creator = new MatrixFromStreamCreator();
        try {
            creator.readInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Matrix matrix = creator.getMatrix();
        MatrixIterator it = (MatrixIterator)matrix.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
        Calculator calc = new Calculator();
        double i = calc.eval("5 5 2 * /");

        System.out.println(i);
    }
}
