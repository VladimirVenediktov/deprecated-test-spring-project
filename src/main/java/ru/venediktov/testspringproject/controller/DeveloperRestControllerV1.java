package ru.venediktov.testspringproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.venediktov.testspringproject.model.User;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * По видео-уроку https://www.youtube.com/watch?v=7uxROJ1nduk&t=2955s
 */
@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

  private List<User> users = Stream.of(
      new User(1L, "Vladimir", "Venediktov", ZonedDateTime.now()),
      new User(2L, "Ivan", "Ivanov", ZonedDateTime.now()))
      .collect(Collectors.toList());

  @GetMapping
  public List<User> getAll() {
    return users;
  }

  @GetMapping("/{id}")
  public User getById(@PathVariable Long id) {
    return users.stream()
        .filter(user -> user.getId().equals(id))
        .findFirst()
        .orElse(null);
  }
}
