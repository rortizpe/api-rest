package com.sermaluc.apirestdemo.builder;

import com.sermaluc.apirestdemo.model.entity.Phone;
import com.sermaluc.apirestdemo.model.entity.User;
import com.sermaluc.apirestdemo.model.request.PhoneRequest;
import com.sermaluc.apirestdemo.model.request.UserRequest;
import com.sermaluc.apirestdemo.model.response.UserResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.sermaluc.apirestdemo.util.DateUtil.parseDateToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserBuilder {

  /**
   * costruye UserResponse desde la entidad User.
   *
   * @param user entidad Usuario.
   * @return UserResponse retorna el userResponse para la vista.
   */
  public static UserResponse buildResponseFromUser(User user) {
    return UserResponse.builder()
        .id(user.getId())
        .created(parseDateToString(user.getCreated()))
        .modified(parseDateToString(user.getUpdate()))
        .lastLogin(parseDateToString(user.getLastLogin()))
        .token(user.getToken())
        .isActive(user.isActive())
        .build();
  }

  /**
   * construye UserResponse desde la el request para poder almacenarlo en la DB.
   * tambien se obtiene valor del contex puesto en el controller.
   *
   * @param userRequest datos del usuario requerido.
   * @return Mono<User> retorna el Mono<User> para poder almacenarce en la DB.
   */
  public static Mono<User> buildUserFromRequestMono(UserRequest userRequest) {
    return Mono.subscriberContext().flatMap(context -> Mono.just(User.builder()
        .name(userRequest.getName())
        .email(userRequest.getEmail())
        .password(userRequest.getPassword())
        .created(LocalDateTime.now())
        .lastLogin(LocalDateTime.now())
        .isActive(true)
        .token(context.get("Authorization"))
        .phones(buildListPhonesFromListRequest(userRequest.getPhones()))
        .build()));
  }

  /**
   * costruye Phones para poder almancenar en la DB.
   *
   * @param phonesRequest lista de telefonos .
   * @return List<Phone> retorna la lista de telefonos modelo.
   */
  public static List<Phone> buildListPhonesFromListRequest(List<PhoneRequest> phonesRequest) {
    return Optional.ofNullable(phonesRequest)
        .orElse(Collections.emptyList())
        .stream()
        .map(UserBuilder::buildPhonesFromRequest)
        .collect(Collectors.toList());
  }

  public static Phone buildPhonesFromRequest(PhoneRequest phoneRequest) {
    return Phone.builder()
        .number(phoneRequest.getNumber())
        .cityCode(phoneRequest.getCityCode())
        .countryCode(phoneRequest.getCountryCode())
        .build();
  }

}
