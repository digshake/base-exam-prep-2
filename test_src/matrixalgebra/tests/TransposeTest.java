package matrixalgebra.tests;

import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import matrixalgebra.utils.MessageFormat;
import nonexam.matrixalgebra.*;


@RunWith(Parameterized.class)
public class TransposeTest {
    private int[][] matrix;
    private int[][] expected;

    public TransposeTest(int[][] matrix, int[][] expected) {
        this.matrix = matrix;
        this.expected = expected;
    }

    public String formatMatricesForMessage(int[][] matrix, int[][] expected, int[][] actual) {
        StringBuilder sb = new StringBuilder();
        sb.append("Original Matrix:\n");
        sb.append(MessageFormat.matrixToString(matrix) + "\n");
        sb.append("Expected Matrix:\n");
        sb.append(MessageFormat.matrixToString(expected) + "\n");
        sb.append("Actual Matrix:\n");
        sb.append(MessageFormat.matrixToString(actual) + "\n");
        return sb.toString();
    }

    @Test
    public void test() throws Exception {
        int[][] actual = MatrixMethods.transpose(matrix);
        assertArrayEquals(formatMatricesForMessage(matrix, actual, expected), expected, actual);
    }

    @Parameterized.Parameters(name = "matrix: {0}; expected: {1};")
    public static Collection<Object[]> getConstructorArguments() {
        return RandomTestCases.getConstructorArgumentsTranspose();
    }
}
