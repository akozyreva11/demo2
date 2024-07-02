package pro.sky.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.demo2.service.CalculatorService;
import pro.sky.demo2.service.CalculatorServiceImpl;
import pro.sky.demo2.NullError.NullError;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Demo2ApplicationTests {

	private final CalculatorService testt= new CalculatorServiceImpl();


	@Test
	public void plusCalculatorTrue() {
		int actual = testt.plusCalculator(8,9);
		int sum= 8+9;
		assertEquals(actual,sum);

	}
	@Test
	public void plusCalculatorFalse() {
		int actual = testt.plusCalculator(9,9);
		int sum= 0+9;
		assertNotEquals(actual,sum);
	}
	@Test
	public void minusCalculatorTrue() {
		int actual = testt.minusCalculator(9,9);
		int sum= 9-9;
		assertEquals(actual,sum);

	}
	@Test
	public void minusCalculatorFalse () {
		int actual = testt.minusCalculator(9,9);
		int sum= 0-9;
		assertNotEquals(actual,sum);
	}
	@Test
	public void multiplyCalculatorTrue() {
		int actual = testt.multiplyCalculator(9,9);
		int sum= 9*9;
		assertEquals(actual,sum);

	}
	@Test
	public void multiplyCalculatorFalse () {
		int actual = testt.multiplyCalculator(9,9);
		int sum= 0*9;
		assertNotEquals(actual,sum);
	}
	@Test
	public void divideCalculatorTrue() {
		int actual = testt.divideCalculator(9,9);
		int sum= 9/9;
		assertEquals(actual,sum);

	}
	@Test
	public void divideCalculatorFalse () {
		int actual = testt.divideCalculator(9,9);
		int sum= 1/9;
		assertNotEquals(actual,sum);
	}

		@Test
		public void testExpectedException() {

assertThrows(NullError.class,()-> testt.divideCalculator(0,0), "Делить на 0 нельзя");}
	}


