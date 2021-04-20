public class Calculator implements ICalculator {
    private ICalculator iCalculator;

    public Calculator(ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }

    @Override
    public int sum(int x, int y) {
        return iCalculator.sum(x, y);
    }

    @Override
    public int minus(int x, int y) {
        return iCalculator.minus(x, y);
    }

    @Override
    public int multiply(int x, int y) {
        return iCalculator.multiply(x, y);
    }

    @Override
    public int division(int x, int y) {
        return iCalculator.division(x, y);
    }
}