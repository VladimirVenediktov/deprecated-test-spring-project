package ru.venediktov.testspringproject.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.venediktov.testspringproject.serializers.ZoneDateTimeSerializer;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class Developer {

  private Long id;
  private String firstName;
  private String lastName;

  /**
   * Дата входа в систему.
   */
  @JsonSerialize(using = ZoneDateTimeSerializer.class)
  private ZonedDateTime dataLogin;

}
