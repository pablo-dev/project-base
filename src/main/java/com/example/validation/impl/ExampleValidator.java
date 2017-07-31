package com.example.validation.impl;

import com.example.validation.Example;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Sample validator.
 *
 * @author Pablo Carnero Liñán
 */
public class ExampleValidator implements ConstraintValidator<Example, String> {

    @Override
    public void initialize(Example example) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // TODO: implement validation
        return true;
    }
}
