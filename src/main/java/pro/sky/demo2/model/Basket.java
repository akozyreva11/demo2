package pro.sky.demo2.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Basket {

    private final List<Integer> bascet;

    public Basket() {

        this.bascet = new ArrayList<>();

    }

    public List<Integer> addItems(List<Integer> Idbascet) {
        bascet.addAll(Idbascet);
        return getItems();
    }

    public List<Integer> getItems() {
        return Collections.unmodifiableList(bascet);
    }
}
