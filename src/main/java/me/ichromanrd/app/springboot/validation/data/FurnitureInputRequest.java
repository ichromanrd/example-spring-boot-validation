package me.ichromanrd.app.springboot.validation.data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FurnitureInputRequest {

    @NotNull(message = "Field 'id' shouldn't be null.")
    @Min(value = 1, message = "ID shouldn't be less than 1.")
    private int id;

    @NotNull(message = "Field 'name' shouldn't be null.")
    @Length(min = 5, message = "Minimum value for field 'name' is 5.")
    private String name;

    @NotNull(message = "Field 'description' shouldn't be null.")
    @Length(min = 10, message = "Minimum value for field 'description' is 5.")
    private String description;
}
