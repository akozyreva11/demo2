package ru.hogwarts.school;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//
@SpringBootApplication
@OpenAPIDefinition
public class Demo2Application {

    public class Main {
        public static void main(String[] args) {
            String str = "I love Java";
            String[] str1 = str.split(" ");
            for (String str2 : str1) {
                System.out.println(str2);
            }
        }
    }

}