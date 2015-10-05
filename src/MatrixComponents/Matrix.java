package MatrixComponents;

import java.util.Iterator;

/**
 * Created by phil on 10/5/2015.
 */
public class Matrix implements Iterable {
    private MatrixElement[][] matrix;
    int height, width;

    public void createMatrix(int height, int width) {
        this.height = height;
        this.width = width;
        matrix = new MatrixElement[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                matrix[i][j] = new MatrixElement();
    }

    public MatrixElement getMatrixElement(int i, int j) {
        if (i < height && j < width)
            return matrix[i][j];
        else throw new RuntimeException("No such element Exception");
    }

    @Override
    public Iterator iterator() {
        return new MatrixIterator(matrix);
    }


    public boolean isValidIndexes(int index, int j) {
        return ((index < height ) && (j < width));
    }
}
