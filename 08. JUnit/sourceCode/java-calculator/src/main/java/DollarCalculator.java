public class DollarCalculator implements ICalculator{
    private int market = 100;

    public DollarCalculator(int market){
        this.market = market;
    }

    @Override
    public int sum(int x, int y) {
        x *= market;
        y *= market;
        return x + y ;
    }

    @Override
    public int minus(int x, int y) {
        x *= market;
        y *= market;
        return x - y;
    }

    @Override
    public int multiply(int x, int y) {
        x *= market;
        y *= market;
        return x * y;
    }

    @Override
    public int division(int x, int y) {
        x *= market;
        y *= market;
        return x / y;
    }
}
