package utils.arrays;

import utils.Display;

public class Matrix2D<T> {
    T[][] cache;

    public Matrix2D(T[][] array) {
        cache = array;
    }

    public boolean isInBounds(int r, int c) {
        return (r >= 0 && r < cache.length) && (c >= 0 && c < cache[0].length);
    }

    public T get(int r, int c, T defaultVal) {
        try {
            return cache[r][c];
        } catch (ArrayIndexOutOfBoundsException e) {
            return defaultVal;
        }
    }

    public T get(int r, int c) {
        return cache[r][c];
    }

    public boolean set(int r, int c, T v) {
        if (isInBounds(r, c)) {
            cache[r][c] = v;
            return true;
        }
        return false;
    }

    public void print() {
        new Display<T>().print(cache);
    }
}
