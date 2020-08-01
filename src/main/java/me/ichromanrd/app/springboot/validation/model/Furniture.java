package me.ichromanrd.app.springboot.validation.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Furniture {
    private int id;
    private String name;
    private String description;
}
