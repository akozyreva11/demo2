package pro.sky.demo2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pro.sky.demo2.model.Bascet;

import java.util.List;
@Service
@SessionScope
public class BascetServiceImpl implements BascetService {
    private final Bascet bascet;

    public BascetServiceImpl(Bascet bascet) {
        this.bascet = bascet;
    }

    public List<Integer> addItem(List<Integer> item) {
        return bascet.addItems(item);
    }

    public List<Integer> getItem() {
        return bascet.getItems();
    }
}
