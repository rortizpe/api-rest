package com.sermaluc.apirestdemo.service;

import com.sermaluc.apirestdemo.model.request.UserRequest;
import com.sermaluc.apirestdemo.model.response.UserResponse;
import reactor.core.publisher.Mono;

public interface UserService {

  Mono<UserResponse> createUser(UserRequest userRequest);
}
