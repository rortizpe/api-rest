package com.sermaluc.apirestdemo.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserResponse {

  private String id;
  private String created;
  private String modified;
  private String lastLogin;
  private String token;
  private boolean isActive;
}
