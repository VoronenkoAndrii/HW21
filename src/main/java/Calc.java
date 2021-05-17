public class Calc {
    public int sum(int a, int b) {
        return a + b;
    }

    public int mult(int a, int b) {
        return a * b;
    }

    public int multAndSum(int a, int b, int c) {
        return mult(sum(a, b), c);
    }

    public boolean isZero(int a) {
        return a == 0;
    }

}
