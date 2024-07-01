package pro.sky.demo2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pro.sky.demo2.model.Basket;

import java.util.List;

@Service
@SessionScope

public class BasketServiceImpl implements BaskettService {
    private final Basket basket;

    public BasketServiceImpl(Basket basket) {
        this.basket = basket;
    }

    public List<Integer> addItem(List<Integer> item) {
        return basket.addItems(item);
    }

    public List<Integer> getItems() {
        return basket.getItems();
    }
}
