package com.example.dto;

import com.example.validation.Example;

import javax.validation.constraints.NotNull;

public class ExampleDto {

    private String id;

    @NotNull(message = "NotNull.ExampleDto.name")
    @Example(message = "ExampleValidation.ExampleDto.name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
