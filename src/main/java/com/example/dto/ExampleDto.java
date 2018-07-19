package com.example.dto;

import com.example.validation.Example;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class ExampleDto {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    @NotNull(message = "NotNull.ExampleDto.name")
    @Example(message = "ExampleValidation.ExampleDto.name")
    private String name;
}
