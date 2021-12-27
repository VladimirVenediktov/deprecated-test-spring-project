package ru.venediktov.testspringproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class Messagesi18nRestController {

  private static final String RUS_LANG = "rus";

  private final MessageSource messageSource;
  private final org.springframework.context.ApplicationContext context;

  @GetMapping("/{lang}")
  public String getMessage(@PathVariable String lang) {
    //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    return messageSource.getMessage("test", null,
            RUS_LANG.equals(lang) ? new Locale("ru") : Locale.ENGLISH);
  }

}
