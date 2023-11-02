package matrixalgebra.tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import matrixalgebra.utils.MessageFormat;
import nonexam.matrixalgebra.*;


@RunWith(Parameterized.class)
public class MultiplyTest {
    private int[][] a;
    private int[][] b;
    private int[][] expected;

    public MultiplyTest(int[][] a, int[][] b, int[][] expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    public String formatMatricesForMessage(int[][] a, int[][] b, int[][] expected, int[][] actual) {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix a:\n");
        sb.append(MessageFormat.matrixToString(a) + "\n");
        sb.append("Matrix b:\n");
        sb.append(MessageFormat.matrixToString(b) + "\n");
        sb.append("Expected Product:\n");
        sb.append(MessageFormat.matrixToString(expected) + "\n");
        sb.append("Actual Product:\n");
        sb.append(MessageFormat.matrixToString(actual) + "\n");
        return sb.toString();
    }

    @Test
    public void test() throws Exception {
        int[][] actual = MatrixMethods.multiply(a, b);
        assertArrayEquals(formatMatricesForMessage(a, b, expected, actual), expected, actual);
    }

    @Parameterized.Parameters(name = "a: {0}; b: {1}; expected: {2};")
    public static Collection<Object[]> getConstructorArguments() {
        return RandomTestCases.getConstructorArgumentsMultiply();
    }
}
