import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Test {
    @Mock
    public MarketServer marketServer;

    @BeforeEach
    public void init(){
        Mockito.lenient().when(marketServer.price()).thenReturn(200);
    }

    @org.junit.jupiter.api.Test
    public void hello(){
        System.out.println("hello");
    }

    @org.junit.jupiter.api.Test
    public void dollar(){
        DollarCalculator dollarCalculator = new DollarCalculator(null);
        Calculator calculator = new Calculator(dollarCalculator);
        int sum = calculator.sum(100, 100);
        Assertions.assertEquals(20000, sum);
    }

    @org.junit.jupiter.api.Test
    public void mock(){
        DollarCalculator dollarCalculator = new DollarCalculator(marketServer);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);
        int sum = calculator.sum(100, 100);
        Assertions.assertEquals(40000, sum);
    }
}
