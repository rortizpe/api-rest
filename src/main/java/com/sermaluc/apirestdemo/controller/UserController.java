package com.sermaluc.apirestdemo.controller;

import com.sermaluc.apirestdemo.model.request.UserRequest;
import com.sermaluc.apirestdemo.model.response.UserResponse;
import com.sermaluc.apirestdemo.service.UserService;
import com.sermaluc.apirestdemo.util.ErrorUtil;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by: Raul Ortiz for Sermaluc
 */
@RestController
@AllArgsConstructor
@RequestMapping()
public class UserController {

  private final UserService userService;

  /**
   * Este controlador se usa para crear usuarios.
   *
   * @return Mono<UserResponse> datos necesarios para la vista.
   */
  @PostMapping(value = "/user")
  @ResponseStatus(HttpStatus.CREATED)
  @ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE,
      value = "crea un nuevo usuario", notes = "crea un nuevo usuario",
      responseContainer = "Collection", response = UserResponse.class)
  public Mono<UserResponse> createUser(@Validated @RequestBody UserRequest userRequest,
                                       BindingResult bindingResult,
                                       @RequestHeader("Authorization") String token
  ) {
    ErrorUtil.errorOfValidation(bindingResult);
    return userService.createUser(userRequest)
        .subscriberContext(context -> context.put("Authorization", token));

  }
}

