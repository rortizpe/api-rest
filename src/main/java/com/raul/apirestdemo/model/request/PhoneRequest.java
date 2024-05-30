package com.sermaluc.apirestdemo.model.request;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(description = "codigo y numero de celular")
public class PhoneRequest {
  private String number;
  private String cityCode;
  private String countryCode;
}
