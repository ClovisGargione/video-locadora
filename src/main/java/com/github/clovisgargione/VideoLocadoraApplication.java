package com.github.clovisgargione;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class VideoLocadoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoLocadoraApplication.class, args);
	}

}
