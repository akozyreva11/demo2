package pro.sky.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.demo2.NullError.DivisionByZeroException;
import pro.sky.demo2.service.CalculatorService;
import pro.sky.demo2.service.CalculatorServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Demo2ApplicationTests {

    private final CalculatorService testt = new CalculatorServiceImpl();


    @Test
    public void must_add_two_numbers_correctly() {
        int actual = testt.plusCalculator(8, 9);
        assertEquals(actual, 17);
    }

    @Test
    public void	must_add_two_numbers_incorrectly() {
        int actual = testt.plusCalculator(9, 9);
        assertNotEquals(actual, 9);
    }

    @Test
    public void must_subtract_two_numbers_correctly() {
        int actual = testt.minusCalculator(9, 9);
        assertEquals(actual, 0);

    }

    @Test
    public void must_subtract_two_numbers_incorrectly() {
        int actual = testt.minusCalculator(9, 9);
        assertNotEquals(actual, -9);
    }

    @Test
    public void must_correctly_multiply_two_numbers() {
        int actual = testt.multiplyCalculator(9, 9);
        assertEquals(actual, 81);

    }

    @Test
    public void must_incorrectly_multiply_two_numbers() {
        int actual = testt.multiplyCalculator(9, 9);
        assertNotEquals(actual, 0);
    }

    @Test
    public void must_correctly_divide_two_numbers() {
        double actual = testt.divideCalculator(3, 2);
        assertEquals(actual, 1.5);

    }

    @Test
    public void must_incorrectly_divide_two_numbers() {
        double actual = testt.divideCalculator(9, 9);
        assertNotEquals(actual, 2);
    }

    @Test
    public void testExpectedException() {
        assertThrows(DivisionByZeroException.class, () -> testt.divideCalculator(0, 0));
    }
}


