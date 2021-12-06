package ru.venediktov.testspringproject.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.venediktov.testspringproject.model.Developer;

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

  private List<Developer> developers = Stream.of(
      new Developer(1L, "Vladimir", "Venediktov", ZonedDateTime.now()),
      new Developer(2L, "Ivan", "Ivanov", ZonedDateTime.now()))
      .collect(Collectors.toList());

  @GetMapping
  public List<Developer> getAll() {
    return developers;
  }

  @GetMapping("/{id}")
  public Developer getById(@PathVariable Long id) {
    return developers.stream()
        .filter(developer -> developer.getId().equals(id))
        .findFirst()
        .orElse(null);
  }
}
