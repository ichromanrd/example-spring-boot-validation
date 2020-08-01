package me.ichromanrd.app.springboot.validation.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FurnitureItemResponse {
    private int id;
    private String name;
    private String description;
}
