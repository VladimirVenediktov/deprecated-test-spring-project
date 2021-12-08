package ru.venediktov.testspringproject.config;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@ConfigurationProperties(prefix = "security")
@Getter
@Setter
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private String login;
  private String password;
  private List<String> roles;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/api/**").fullyAuthenticated()
        .and()
        .httpBasic();
  }

  @Bean
  @Override
  protected UserDetailsService userDetailsService() {
    return new InMemoryUserDetailsManager(
        User.builder()
            .username(login)
            .password(passwordEncoder().encode(password))
            .roles(roles.toArray(new String[0]))
            .build());
  }

  /*@Bean
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
              .passwordEncoder(passwordEncoder())
              .withUser("admin")
              .password("admin")
              .roles("ADMIN");
  }*/

  @Bean
  protected PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }
}
