package com.sermaluc.apirestdemo.validation.string;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = OneOfValidatorString.class)
public @interface OneOfString {

  String[] acceptedValues();

  String message() default "value must match one of the values in the list";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  int[] value() default {};
}
