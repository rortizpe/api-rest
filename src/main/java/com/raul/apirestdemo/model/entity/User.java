package com.sermaluc.apirestdemo.model.entity;

import com.sermaluc.apirestdemo.model.request.PhoneRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@Builder
@Document(collection = "user")
public class User {

  @Id
  private String id;
  private String name;
  @Indexed(unique = true)
  private String email;
  private String password;
  private List<Phone> phones;
  private LocalDateTime created;
  private LocalDateTime update;
  private LocalDateTime lastLogin;
  private boolean isActive;
  private String token;

}
