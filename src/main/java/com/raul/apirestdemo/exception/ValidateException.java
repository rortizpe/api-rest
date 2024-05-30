package com.sermaluc.apirestdemo.exception;

import lombok.Getter;

@Getter
public class ValidateException extends RuntimeException {

  private final MessageErrorResponse errMsg;

  public ValidateException(MessageErrorResponse errMsg) {
    this.errMsg = errMsg;
  }
}
