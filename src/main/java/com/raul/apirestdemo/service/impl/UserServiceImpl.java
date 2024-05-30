package com.sermaluc.apirestdemo.service.impl;

import com.sermaluc.apirestdemo.builder.UserBuilder;
import com.sermaluc.apirestdemo.exception.CustomException;
import com.sermaluc.apirestdemo.model.request.UserRequest;
import com.sermaluc.apirestdemo.model.response.UserResponse;
import com.sermaluc.apirestdemo.repository.UserRepository;
import com.sermaluc.apirestdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public Mono<UserResponse> createUser(UserRequest userRequest) {
    return Mono.just(userRequest)
        .flatMap(UserBuilder::buildUserFromRequestMono)
        .flatMap(userRepository::save)
        .map(UserBuilder::buildResponseFromUser)
        .onErrorResume(throwable ->Mono.defer(() -> Mono.error(CustomException.builder()
            .errorMessage(throwable.getMessage())
            .build())));
  }
}
