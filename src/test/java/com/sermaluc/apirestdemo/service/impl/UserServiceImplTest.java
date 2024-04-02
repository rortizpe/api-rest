package com.sermaluc.apirestdemo.service.impl;

import com.sermaluc.apirestdemo.exception.CustomException;
import com.sermaluc.apirestdemo.model.entity.User;
import com.sermaluc.apirestdemo.model.request.UserRequest;
import com.sermaluc.apirestdemo.model.response.UserResponse;
import com.sermaluc.apirestdemo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.context.Context;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class UserServiceImplTest {

  private static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoicmF1bCIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE3MTIwNzUxNzcsImV4cCI6MTcxMjA3NTc3N30.TuraJpiooGmjSjtEG5fMCcpj-XwIU81d7Ca3AnZg39I1tlSVik2itkhzqjcI2ExYbSKh5Ey3S1EzUY2Fl8C98A";
  @Mock
  private UserRepository userRepository;
  @InjectMocks
  private UserServiceImpl userService;

  @Test
  void createUser() {
    when(userRepository.save(any(User.class)))
        .thenReturn(Mono.just(User.builder().id("660c211cde7b3f1c24bdc308").build()));
    Mono<UserResponse> userResponseMono = userService.createUser(UserRequest.builder().name("Raul").email("asb@avc.cac").password("!Aa1aaaa").build())
        .subscriberContext(Context.of("Authorization", TOKEN));

    StepVerifier.create(userResponseMono)
        .expectNextMatches(userResponse -> userResponse.getId().equals("660c211cde7b3f1c24bdc308"))
        .verifyComplete();
  }

  @Test
  void createUserError() {
    when(userRepository.save(any(User.class)))
        .thenThrow(CustomException.class);
    Mono<UserResponse> userResponseMono = userService.createUser(UserRequest.builder().name("Raul").email("asb@avc.cac").password("!Aa1aaaa").build())
        .subscriberContext(Context.of("Authorization", TOKEN));

    StepVerifier.create(userResponseMono)
        .expectError(CustomException.class)
        .verify();
  }
}