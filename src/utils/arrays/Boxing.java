package utils.arrays;

public class Boxing {
    public static Integer[] toInteger1DArray(int[] array) {
        if (array.length == 0)
            return null;
        Integer[] newArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static Integer[][] toInteger2DArray(int[][] matrix) {
        if (matrix.length == 0)
            return null;
        Integer[][] newArray = new Integer[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            newArray[i] = toInteger1DArray(matrix[i]);
        }
        return newArray;
    }
}
