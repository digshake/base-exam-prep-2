package matrixalgebra.utils;

public class MessageFormat {
    public static String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; ++i) {
            sb.append("[ ");
            for (int j = 0; j < matrix[0].length; ++j) {
                sb.append(String.format("%3d ", matrix[i][j]));
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}
