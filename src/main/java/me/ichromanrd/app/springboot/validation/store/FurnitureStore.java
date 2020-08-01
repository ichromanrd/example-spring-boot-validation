package me.ichromanrd.app.springboot.validation.store;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import me.ichromanrd.app.springboot.validation.model.Furniture;

@Component
public class FurnitureStore {

    private final Map<Integer, Furniture> FURNITURES = new HashMap() {
        {
            put(1, new Furniture(1, "Table", "This is a table"));
            put(2, new Furniture(2, "Table", "This is a table"));
            put(3, new Furniture(3, "Table", "This is a table"));
            put(4, new Furniture(4, "Table", "This is a table"));
            put(5, new Furniture(5, "Table", "This is a table"));
            put(6, new Furniture(6, "Table", "This is a table"));
        }
    };

    public Map<Integer, Furniture> getFurnitures() {
        return FURNITURES;
    }
}
