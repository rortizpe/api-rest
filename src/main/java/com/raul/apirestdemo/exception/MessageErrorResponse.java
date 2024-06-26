package com.sermaluc.apirestdemo.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MessageErrorResponse {
  private List<String> error;
}
