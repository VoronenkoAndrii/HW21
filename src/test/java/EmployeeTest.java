import org.testng.annotations.Test;

import static org.testng.Assert.assertEqualsNoOrder;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class EmployeeTest {

    private static String[] positions = new String[]{"JUN", "MIDDLE"};

    private Employee employee = new Employee();

    @Test
    public void test1Positions() throws Exception {
        assertNull(employee.getPositions());
    }

    @Test
    public void test1QAPositions() throws Exception {
        assertArrayEquals(positions, employee.getPositionsQA());
    }

    @Test
    public void test2Positions() throws Exception {
        assertEqualsNoOrder(positions, employee.getPositions());
    }

    @Test
    public void test2QAPositions() throws Exception {
        assertEqualsNoOrder(positions, employee.getPositionsQA());
    }

    @Test(timeOut = 5000)
    public void test3QAPositions() throws InterruptedException {
        Thread.sleep(400);
        System.out.println("Time test method");
    }

    @Test(expectedExceptions = {NullPointerException.class})
    public void test4QAPositions() {
        throw new NullPointerException();
    }
}
