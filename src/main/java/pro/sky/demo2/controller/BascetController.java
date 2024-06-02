package pro.sky.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.demo2.service.BascetService;

import java.util.List;


@Controller
@RestMapping("/store/order")


public class BascetController
{
    private final BascetService bascetService;

    public BascetController(BascetService bascetService) {
        this.bascetService = bascetService;
    }
    @GetMapping ("/add")
    public List<Integer> addItem (@RequestParam List<Integer> Iditem)
    {
        return bascetService.addItem(Iditem);
    }
    @GetMapping ("/getItem")

    public List<Integer> getItem (){
        return bascetService.getItem();
    }

}
