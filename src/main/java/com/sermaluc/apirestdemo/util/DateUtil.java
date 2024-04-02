package com.sermaluc.apirestdemo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
  public static final String DATE_TIME_AMPM_FORMAT = "dd/MM/yyyy hh:mm:ss";

  public static String parseDateToString(LocalDateTime date) {
    return date != null ? date.format(DateTimeFormatter.ofPattern(DATE_TIME_AMPM_FORMAT)) : null;
  }
}
