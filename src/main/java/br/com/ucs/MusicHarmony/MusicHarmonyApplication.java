package br.com.ucs.MusicHarmony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "br.com.ucs.MusicHarmony.model")
@SpringBootApplication // É responsável por dispor diversas funcionalidades, sem que para isso tenhamos que fazer qualquer configuração
public class MusicHarmonyApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusicHarmonyApplication .class, args);
	}
}