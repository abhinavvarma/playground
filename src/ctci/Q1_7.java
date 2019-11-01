package ctci;

import utils.Display;


class InvalidParams extends Exception {

}

class Cell {
    int[][] a;
    int i, j;
    
    public Cell(int[][] a, int i, int j) {
        this.a = a;
        this.i = i;
        this.j = j;
    }
    
    public int get() {
        try {
            return a[i][j];
        } catch (ArrayIndexOutOfBoundsException ar) {
            return -1;
        }

    }
    
    public int set(int v) {
        return a[i][j] = v;
    }
}


class Matrix {
    int[][] a;

    public Matrix(int[][] a) {
        this.a = a;
    }

    public int getNoOfLayers() {
        return a[0].length / 2;
    }

    private int getLayerStartIndex(int layer) {
        return layer;
    }

    private int getLayerEndIndex(int layer) {
        return a[0].length - layer - 1;
    }

    private boolean isInBetween(int start, int key, int end) {
        return start <= key && key <= end;
    }

    public Cell top(int layer, int offset) throws InvalidParams {
        offset = layer + offset;
        if (layer <= getNoOfLayers() || isInBetween(getLayerStartIndex(layer), offset, getLayerEndIndex(layer))) {
            return new Cell(a, layer, offset);
        }

        throw new InvalidParams();
    }

    public Cell left(int layer, int offset) throws InvalidParams {
        offset = a[0].length - layer - offset - 1;
        if (layer <= getNoOfLayers() || isInBetween(getLayerStartIndex(layer), offset, getLayerEndIndex(layer))) {
            return new Cell(a, layer, offset);
        }

        throw new InvalidParams();
    }

    public Cell bottom(int layer, int offset) throws InvalidParams {
        offset = a[0].length - layer - offset - 1;
        if (layer <= getNoOfLayers() || isInBetween(getLayerStartIndex(layer), offset, getLayerEndIndex(layer))) {
            return new Cell(a, layer, offset);
        }

        throw new InvalidParams();
    }

    public Cell right(int layer, int offset) throws InvalidParams {
        offset = layer + offset;
        if (layer <= getNoOfLayers() || isInBetween(getLayerStartIndex(layer), offset, getLayerEndIndex(layer))) {
            return new Cell(a, layer, offset);
        }

        throw new InvalidParams();
    }

    public int[][] rotate90() throws InvalidParams {
        for (int layer = 0; layer < getNoOfLayers(); layer++) {
            for (int i = getLayerStartIndex(layer); i <= getLayerEndIndex(layer); i++) {
                int temp = top(layer, i).get();
                top(layer, i).set(left(layer, i).get());
                left(layer, i).set(bottom(layer, i).get());
                bottom(layer, i).set(right(layer, i).get());
                right(layer, i).set(temp);
            }
            System.out.println("---------Layer------------- " + layer);
            //Display.print2dArray(a);
        }
        return a;
    }

}


public class Q1_7 {
    public static void main(String[] args) throws InvalidParams {
        Matrix matrix = new Matrix(new int[][] {
                {0, 1, 2, 3},
                {10, 11, 12, 13},
                {20, 21, 22, 23},
                {30, 31, 32, 33},
        });
        int[][] a = matrix.rotate90();
//        //Display.print2dArray(a);
    }
}
