package com.sermaluc.apirestdemo.validation.string;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class OneOfValidatorString implements ConstraintValidator<OneOfString, String> {
  private List<String> valueList;

  @Override
  public void initialize(OneOfString constraintAnnotation) {
    valueList = new ArrayList<String>();
    for (String val : constraintAnnotation.acceptedValues()) {
      valueList.add(val.toUpperCase());
    }
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (!valueList.contains(value.toUpperCase())) {
      return false;
    }
    return true;
  }

}
