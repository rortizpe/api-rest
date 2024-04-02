package com.sermaluc.apirestdemo.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JWTUser {

  private String user;
  private String token;


}
