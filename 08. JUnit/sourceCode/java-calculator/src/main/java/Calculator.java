public class Calculator {
    private ICalculator iCalculator;

    public Calculator(ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }

    public int sum(int x, int y) {
        return iCalculator.sum(x, y);
    }

    public int minus(int x, int y) {
        return iCalculator.minus(x, y);
    }

    public int multiply(int x, int y) {
        return iCalculator.multiply(x, y);
    }

    public int division(int x, int y) {
        return iCalculator.division(x, y);
    }
}