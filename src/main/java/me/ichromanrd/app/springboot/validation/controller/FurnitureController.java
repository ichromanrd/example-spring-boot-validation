package me.ichromanrd.app.springboot.validation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.ichromanrd.app.springboot.validation.data.FurnitureInputRequest;
import me.ichromanrd.app.springboot.validation.data.FurnitureItemResponse;
import me.ichromanrd.app.springboot.validation.data.FurnitureSearchRequest;
import me.ichromanrd.app.springboot.validation.model.Furniture;
import me.ichromanrd.app.springboot.validation.store.FurnitureStore;

@RestController
@RequestMapping("/furnitures")
@RequiredArgsConstructor
public class FurnitureController {

    private final FurnitureStore store;

    @GetMapping
    public List<FurnitureItemResponse> getAllFurnitures() {
        return store.getFurnitures().values()
                    .stream()
                    .map(this::toResponse)
                    .collect(Collectors.toList());
    }

    @PostMapping("/search")
    public List<FurnitureItemResponse> searchFurnitures(@Valid @RequestBody FurnitureSearchRequest request) {
        Furniture furniture = store.getFurnitures().get(request.getId());

        if (furniture == null) {
            return store.getFurnitures().values()
                 .stream()
                 .filter(f -> f.getName().contains(request.getName()))
                 .map(this::toResponse)
                 .collect(Collectors.toList());
        } else
            return Arrays.asList(toResponse(furniture));
    }

    @PostMapping
    public void saveFurniture(@Valid @RequestBody FurnitureInputRequest request) {
        store.getFurnitures().put(
            request.getId(),
            new Furniture(request.getId(), request.getName(), request.getDescription())
        );
    }

    private FurnitureItemResponse toResponse(Furniture furniture) {
        return new FurnitureItemResponse(furniture.getId(), furniture.getName(), furniture.getDescription());
    }

}
