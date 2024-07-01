package pro.sky.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.demo2.service.BaskettService;

import java.util.List;


@Controller
@RequestMapping("/store/order")


public class BasketController {
    private final BaskettService baskettService;

    public BasketController(BaskettService baskettService) {
        this.baskettService = baskettService;
    }

    @GetMapping("/add")
    public List<Integer> addItem(@RequestParam List<Integer> IdItem) {
        return baskettService.addItem(IdItem);
    }

    @GetMapping("/getItems")

    public List<Integer> getItems() {
        return baskettService.getItems();
    }

}
