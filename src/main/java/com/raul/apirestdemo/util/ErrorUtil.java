package com.sermaluc.apirestdemo.util;

import com.sermaluc.apirestdemo.exception.MessageErrorResponse;
import com.sermaluc.apirestdemo.exception.ValidateException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorUtil {
  public static void errorOfValidation(BindingResult br) {
    if (br.hasErrors()) {
      List<String> errorList = new ArrayList<>();
      for (FieldError e : br.getFieldErrors()) {
        errorList.add(e.getDefaultMessage());
      }
      if (!errorList.isEmpty()) {
        throw new ValidateException(MessageErrorResponse.builder()
            .error(errorList)
            .build());
      }
    }
  }
}
