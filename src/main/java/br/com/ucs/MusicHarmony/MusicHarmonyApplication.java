package br.com.ucs.MusicHarmony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "br.com.ucs.MusicHarmony.model")
@SpringBootApplication
public class MusicHarmonyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicHarmonyApplication .class, args);
	}

}
