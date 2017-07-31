package com.example.validation;

import com.example.validation.impl.ExampleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Departament exists constraint
 *
 * @author Pablo Carnero Liñán
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {ExampleValidator.class}
)
public @interface Example {
    String message();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
