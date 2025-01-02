package com.github.clovisgargione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Encoder {

	@Bean
    PasswordEncoder userPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}
