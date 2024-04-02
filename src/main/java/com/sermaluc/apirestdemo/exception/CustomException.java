package com.sermaluc.apirestdemo.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomException extends RuntimeException {

  private final String errorMessage;


  public CustomException(String errorMsg) {
    this.errorMessage = errorMsg;
  }

}
