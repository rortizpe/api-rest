package com.sermaluc.apirestdemo.validation.password;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


public class PasswordFormatValidator implements ConstraintValidator<Password, String> {

  @Value("${password.pattern}")
  private String passwordPattern;
  private Pattern pattern;

  @Override
  public void initialize(Password constraintAnnotation) {
    pattern = Pattern.compile(passwordPattern);
  }

  @Override
  public boolean isValid(String password, ConstraintValidatorContext cxt) {
    return password != null && pattern.matcher(password).matches();
  }
}
