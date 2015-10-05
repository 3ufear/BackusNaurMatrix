package Matrix;

import java.util.Iterator;

/**
 * Created by phil on 10/5/2015.
 */
public class Matrix implements Iterable {
    private MatrixElement[][] matrix;

    public void createMatrix(int height, int width) {
        matrix = new MatrixElement[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                matrix[i][j] = new MatrixElement();
    }

    @Override
    public Iterator iterator() {
        return new MatrixIterator(matrix);
    }


}
