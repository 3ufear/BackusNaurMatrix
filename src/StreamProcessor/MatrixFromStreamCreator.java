package StreamProcessor;

import java.io.*;
import java.util.Iterator;

import Matrix.Matrix;
import Matrix.MatrixIterator;

/**
 * Created by phil on 10/5/2015.
 */
public class MatrixFromStreamCreator {
    private Matrix matrix;

    public MatrixFromStreamCreator() {
        matrix = new Matrix();
    }

    public void readInputStream() throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String str = buffer.readLine();
        createArrayForParams(str);
        MatrixIterator it = (MatrixIterator) matrix.iterator();
        while (true) {
            str = buffer.readLine();
            if (str == null)
                    break;
            if (it.hasNext())
                it.next().setExpression(str);
            else
                break;
        }
        buffer.close();


    }

    public Matrix getMatrix() {
        return matrix;
    }

    private void createArrayForParams(String params) throws Exception {
        String[] sizes = params.split(" ");
        if (sizes.length < 2) {
            throw new Exception("Not enough parameters in first line");
        }
        matrix.createMatrix(Integer.parseInt(sizes[1]),Integer.parseInt(sizes[0]));// = new String[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[0])];
    }

}
