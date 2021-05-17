import org.testng.Assert;
import org.testng.annotations.*;

public class CalcTest {
    private Calc calc = new Calc();

    @BeforeClass
    public void beforeCalcClass() {
        System.out.println("beforeCalcClass");
    }

    @AfterClass
    public void AfterCalcClass() {
        System.out.println("AfterCalcClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeCalcMethod");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("AfterCalcMethod");
    }

    @Test
    public void testSum2() throws Exception {
        Assert.assertEquals(5, calc.sum(2, 3));
    }

    @Test(priority = 1)
    public void testSum() throws Exception {
        Assert.assertEquals(6, calc.sum(2, 3));
    }

    @Test(dataProvider = "test-data-sum")
    public void testSumGen(int first,int second, int sum) throws Exception {
        Assert.assertEquals(sum, calc.sum(first, second));
    }

    @DataProvider(name = "test-data-sum")
    public Object[][] dataProvFunc() {
        return new Object[][]{
                {1,2,3},
                {3,4,7}
        };
    }

    @Test
    public void testMult() throws Exception {
        Assert.assertEquals(5, calc.mult(2, 3));
    }

    @Test
    public void testIsZero() {
        Assert.assertFalse(calc.isZero(6));

    }

    @Test(dependsOnMethods = {"testSum", "testMult"})
    public void testMultAndSum() throws Exception {
        System.out.printf("success in testSum and testMult ");
        Assert.assertTrue(true);

    }

    @Parameters({"firstName"})
    @Test
    public void parametersTestOne(String firstName) {
        System.out.printf("Invoked testParameters " + firstName);
        assert "Cedric".equals(firstName);

    }

    @Test
    public void test2() {
        String baseUrl = PropertiesReaderClassLoader.getInstance().getValueFromProperty( "baseUrl");
        String defaultTimeoutValue = PropertiesReaderClassLoader.getInstance().getValueFromProperty( "defaultTimeout");
        System.out.println("baseUrl = " + baseUrl);
        System.out.println("defaultTimeoutValue = " + defaultTimeoutValue);}
}

