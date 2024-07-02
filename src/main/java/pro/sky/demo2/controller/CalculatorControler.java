package pro.sky.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.demo2.service.CalculatorService;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorControler {

    private final CalculatorService calculatorService;

    public CalculatorControler(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(path = "")

    public String answerCalculator() {
        return "Добро пожаловать  в калькулятор";
    }

    //http://localhost:8080/calculator/plus?num1=5&num2=7
    @GetMapping(path = "/plus")
    public String plusCalculator(@RequestParam int num1, @RequestParam int num2) {
        return String.valueOf(calculatorService.plusCalculator(num1, num2));
    }

    //http://localhost:8080/calculator/plus?num1=7&num2=7
    @GetMapping(path = "/minus")
    public String minusCalculator(@RequestParam int num1, @RequestParam int num2) {
        return String.valueOf(calculatorService.minusCalculator(num1, num2));
    }

    //http://localhost:8080/calculator/multiply?num1=7&num2=7
    @GetMapping(path = "/multiply")
    public String multiplyCalculator(@RequestParam int num1, @RequestParam int num2) {
        return String.valueOf(calculatorService.multiplyCalculator(num1, num2));

    }

    // http://localhost:8080/calculator/divide?num1=9&num2=9
    @GetMapping(path = "/divide")
    public String divideCalculator(@RequestParam double num1, double num2) {
        return String.valueOf(calculatorService.divideCalculator(num1, num2));
    }
}