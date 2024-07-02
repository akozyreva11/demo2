package pro.sky.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.demo2.service.CalculatorService;
import pro.sky.demo2.service.CalculatorServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Demo2ApplicationTests {

    private final CalculatorService testt = new CalculatorServiceImpl();


    @Test
    public void shouldAddTwoNumbersCorrectly() {
        int actual = testt.plusCalculator(8, 9);
        int sum = 8 + 9;
        assertEquals(actual, sum);

    }

    @Test
    public void	mustaddtwonumbersincorrectly() {
        int actual = testt.plusCalculator(9, 9);
        int sum = 0 + 9;
        assertNotEquals(actual, sum);
    }

    @Test
    public void mustsubtracttwonumberscorrectly() {
        int actual = testt.minusCalculator(9, 9);
        int sum = 9 - 9;
        assertEquals(actual, sum);

    }

    @Test
    public void mustsubtracttwonumbersincorrectly() {
        int actual = testt.minusCalculator(9, 9);
        int sum = 0 - 9;
        assertNotEquals(actual, sum);
    }

    @Test
    public void mustcorrectlymultiplytwonumbers() {
        int actual = testt.multiplyCalculator(9, 9);
        int sum = 9 * 9;
        assertEquals(actual, sum);

    }

    @Test
    public void mustincorrectlymultiplytwonumbers() {
        int actual = testt.multiplyCalculator(9, 9);
        int sum = 0 * 9;
        assertNotEquals(actual, sum);
    }

    @Test
    public void mustcorrectlydividetwonumbers() {
        int actual = testt.divideCalculator(9, 9);
        int sum = 9 / 9;
        assertEquals(actual, sum);

    }

    @Test
    public void mustincorrectlydividetwonumbers() {
        int actual = testt.divideCalculator(9, 9);
        int sum = 1 / 9;
        assertNotEquals(actual, sum);
    }

    @Test
    public void testExpectedException() {

        assertThrows(IllegalArgumentException.class, () -> testt.divideCalculator(0, 0));
    }
}


