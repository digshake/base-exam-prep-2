package matrixalgebra.utils;

public class RandomMatrixGenerator {

    public static void main(String[] args) {

        // // Transpose
        // int[][][] matrices = new int[20][][];
        // int[][][] expecteds = new int[20][][];

        // for (int i = 0; i < matrices.length; ++i) {
        // matrices[i] = generateRandomMatrix();
        // expecteds[i] = transpose(matrices[i]);
        // }

        // // for (int i = 0; i < matrices[0].length; ++i) {
        // // for (int j = 0; j < matrices[0][0].length; ++j) {
        // // System.out.print(matrices[0][i][j] + " ");
        // // }
        // // }
        // // System.out.println(formatMatrixForTestSuite(matrices[0]));

        // for (int i = 0; i < matrices.length; ++i) {
        // System.out.println(formatBothMatricesForTestSuite(matrices[i],
        // expecteds[i]));
        // }

        // // System.out.println(formatFullForTestSuite(matrices, expecteds));

        // Add
        // int[][][] aMatrices = new int[20][][];
        // int[][][] bMatrices = new int[20][][];
        // int[][][] expecteds = new int[20][][];

        // for (int i = 0; i < aMatrices.length; ++i) {
        // aMatrices[i] = generateRandomMatrix();
        // bMatrices[i] = generateRandomMatrixAdd(aMatrices[i].length,
        // aMatrices[i][0].length);
        // expecteds[i] = add(aMatrices[i], bMatrices[i]);
        // }

        // for (int i = 0; i < aMatrices.length; ++i) {
        // System.out.println(formatBothMatricesForTestSuite(aMatrices[i], bMatrices[i],
        // expecteds[i]));
        // }

        // Multiply
        // int[][][] aMatrices = new int[20][][];
        // int[][][] bMatrices = new int[20][][];
        // int[][][] expecteds = new int[20][][];
        // for (int i = 0; i < aMatrices.length; ++i) {
        // aMatrices[i] = generateRandomMatrix();
        // bMatrices[i] = generateRandomMatrixMultiply(aMatrices[i][0].length);
        // expecteds[i] = multiply(aMatrices[i], bMatrices[i]);
        // }

        // for (int i = 0; i < aMatrices.length; ++i) {
        // System.out.println(formatBothMatricesForTestSuite(aMatrices[i], bMatrices[i],
        // expecteds[i]));
        // }

        // Determinant
        int[][][] matrices = new int[20][][];
        int[] expecteds = new int[20];
        for (int i = 0; i < matrices.length; ++i) {
            matrices[i] = generateRandomMatrixDeterminant((int) (Math.random() * 8 + 2));
            expecteds[i] = determinant(matrices[i]);
        }
        System.out.println(formatFullForTestSuiteWithIntegers(matrices, expecteds));
    }

    public static int[][] generateRandomMatrix() {
        int rows = (int) (Math.random() * 10 + 1);
        int cols = (int) (Math.random() * 10 + 1);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }

        return matrix;
    }

    public static int[][] generateRandomMatrixAdd(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static int[][] generateRandomMatrixMultiply(int rows) {
        int cols = (int) (Math.random() * 10 + 1);
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static int[][] generateRandomMatrixDeterminant(int rows) {
        int[][] matrix = new int[rows][rows];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < rows; ++j) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static String formatFullForTestSuiteWithIntegers(int[][][] matrices, int[] expecteds) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrices.length; ++i) {
            sb.append("args.add( new Object[]{");
            sb.append("new int[][] ");
            sb.append(formatMatrixForTestSuite(matrices[i]) + ", " + expecteds[i]);
            sb.append("});\n");
        }
        return sb.toString();
    }

    public static String formatFullForTestSuite(int[][][] matrices, int[][][] expecteds) {
        StringBuilder sb = new StringBuilder();
        sb.append("return new Arrays.asList(\n");
        for (int i = 0; i < matrices.length; ++i) {
            sb.append("new int[][][] {");
            sb.append(formatMatrixForTestSuite(matrices[i]) + ", " + formatMatrixForTestSuite(expecteds[i]));
            sb.append("}");
            if (i != matrices.length - 1) {
                sb.append(",");
            }
        }
        sb.append(");");
        return sb.toString();
    }

    public static String formatBothMatricesForTestSuite(int[][]... matrices) {
        StringBuilder sb = new StringBuilder();
        sb.append("new int[][][] {");
        for (int i = 0; i < matrices.length; ++i) {
            sb.append(formatMatrixForTestSuite(matrices[i]));
            if (i != matrices.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static String formatMatrixForTestSuite(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < matrix.length; ++i) {
            sb.append("{");
            for (int j = 0; j < matrix[0].length; ++j) {
                sb.append(matrix[i][j]);
                if (j != matrix[0].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            if (i != matrix.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();

    }

    public static int[][] transpose(int[][] a) {
        int[][] ans = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                ans[j][i] = a[i][j];
            }
        }
        return ans;
    }

    public static int[][] add(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("Matrix dimensions incompatible");
        }

        int[][] ans = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                ans[i][j] = a[i][j] + b[i][j];
            }
        }
        return ans;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalArgumentException("Matrix dimensions incompatible");
        }

        int[][] ans = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                int dotProduct = 0;
                for (int k = 0; k < a[0].length; k++) {
                    dotProduct += a[i][k] * b[k][j];
                }
                ans[i][j] = dotProduct;
            }
        }

        return ans;
    }

    public static int determinant(int[][] a) {
        if (a.length <= 2 && a[0].length <= 2) {
            return a[0][0] * a[1][1] - a[0][1] * a[1][0];
        }

        int sum = 0;
        for (int i = 0; i < a.length; ++i) {
            int[][] subMatrix = new int[a.length - 1][a[0].length - 1];
            int currentCol = 0;
            for (int c = 0; c < a.length; ++c) {
                if (c != i) {
                    for (int r = 1; r < a.length; ++r) {
                        subMatrix[r - 1][currentCol] = a[r][c];
                    }
                    currentCol++;
                }
            }
            if (i % 2 == 0) {
                sum += a[0][i] * determinant(subMatrix);
            } else {
                sum -= a[0][i] * determinant(subMatrix);
            }
        }

        return sum;
    }
}
