package com.sermaluc.apirestdemo.model.request;

import com.sermaluc.apirestdemo.validation.password.Password;
//import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import java.util.List;

@Getter
@Builder
//  @ApiModel(description = "datos necesarios para crear el Usuario")
public class UserRequest {

  private String name;
  @Email(regexp = ".+[@].+[\\.].+")
  private String email;
  @Password
  private String password;
  private List<PhoneRequest> phones;

}
