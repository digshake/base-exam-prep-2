package matrixalgebra.tests;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import matrixalgebra.utils.MessageFormat;
import nonexam.matrixalgebra.*;


@RunWith(Parameterized.class)
public class DeterminantTest {
    private int[][] matrix;
    private int expected;

    public DeterminantTest(int[][] matrix, int expected) {
        this.matrix = matrix;
        this.expected = expected;
    }

    public String formatMatricesForMessage(int[][] matrix, int expected, int actual) {
        StringBuilder sb = new StringBuilder();
        sb.append("Original Matrix:\n");
        sb.append(MessageFormat.matrixToString(matrix) + "\n");
        sb.append("Expected Determinant:\n");
        sb.append(expected + "\n");
        sb.append("Actual Determinant:\n");
        sb.append(actual + "\n");
        return sb.toString();
    }

    @Test
    public void test() throws Exception {
        int actual = MatrixMethods.determinant(matrix);
        assertEquals(formatMatricesForMessage(matrix, actual, expected), expected, actual);
    }

    @Parameterized.Parameters(name = "matrix: {0}; expected: {1};")
    public static Collection<Object[]> getConstructorArguments() {
        return RandomTestCases.getConstructorArgumentsDeterminant();
    }
}
