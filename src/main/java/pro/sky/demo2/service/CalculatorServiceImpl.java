package pro.sky.demo2.service;

import org.springframework.stereotype.Service;
import pro.sky.demo2.NullError.NullError;

@Service
public class CalculatorServiceImpl implements CalculatorService  {


    @Override
    public int plusCalculator(int num1, int num2) {
        return num1 + num2;

    }

    @Override
    public int minusCalculator(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiplyCalculator(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divideCalculator(int num1, int num2)  {
        if (num2 == 0) {
           throw new NullError();
        }
        return num1 / num2;
    }
}
