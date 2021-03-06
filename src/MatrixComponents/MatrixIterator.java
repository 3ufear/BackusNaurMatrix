package MatrixComponents;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by phil on 10/5/2015.
 */
public class MatrixIterator implements Iterator {
    int height;
    int width;
    MatrixElement[][] matrix;
    int cur_i = 0,cur_j = -1;


    public MatrixIterator(MatrixElement[][] matrix) {
        this.matrix = matrix;
        height = matrix.length;
        width = matrix[0].length;
    }

    @Override
    public boolean hasNext() {
         return !(cur_i == (height -1) && cur_j == (width - 1));
    }

    @Override
    public MatrixElement next() {
        if(cur_j == width - 1) {
            cur_j = 0;
            cur_i++;
        } else {
            cur_j++;
        }
        if (cur_j > width || cur_i > height)
            throw new NoSuchElementException("There are no more elements in matrix");
        return matrix[cur_i][cur_j];
    }

    @Override
    public void remove() {
          throw new RuntimeException("Method not implemented yet");
    }
}
