package com.sermaluc.apirestdemo.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class ValidateException extends RuntimeException {

  private final MessageErrorResponse errMsg;

  public ValidateException(MessageErrorResponse errMsg) {
    this.errMsg = errMsg;
  }
}
