package ctci;

class InvalidParams extends Exception {

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

    public int top(int layer, int offset) throws InvalidParams {
        offset = layer + offset;
        if (layer <= getNoOfLayers() || isInBetween(getLayerStartIndex(layer), offset, getLayerEndIndex(layer))) {
            return a[layer][offset];
        }

        throw new InvalidParams();
    }

    public int left(int layer, int offset) throws InvalidParams {
        offset = a[0].length - layer - offset;
        if (layer <= getNoOfLayers() || isInBetween(getLayerStartIndex(layer), offset, getLayerEndIndex(layer))) {
            return a[layer][offset];
        }

        throw new InvalidParams();
    }

    public int bottom(int layer, int offset) throws InvalidParams {
        offset = layer + offset;
        if (layer <= getNoOfLayers() || isInBetween(getLayerStartIndex(layer), offset, getLayerEndIndex(layer))) {
            return a[layer][offset];
        }

        throw new InvalidParams();
    }

    public int right(int layer, int offset) throws InvalidParams {
        offset = layer + offset;
        if (layer <= getNoOfLayers() || isInBetween(getLayerStartIndex(layer), offset, getLayerEndIndex(layer))) {
            return a[layer][offset];
        }

        throw new InvalidParams();
    }

    public int[][] rotate90() {
        return a;
    }

}


public class Q1_7 {
    public static void main(String[] args) {

    }
}
