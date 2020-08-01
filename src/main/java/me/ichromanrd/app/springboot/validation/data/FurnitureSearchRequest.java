package me.ichromanrd.app.springboot.validation.data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class FurnitureSearchRequest {

    @NotNull(message = "Field 'id' shouldn't be null.")
    @Min(value = 1, message = "ID shouldn't be less than 1.")
    private int id;

    @NotNull(message = "Field 'name' shouldn't be null.")
    @Length(min = 5, message = "Minimum length of field 'name' is 5.")
    private String name;

}
