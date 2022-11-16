package br.com.ucs.MusicHarmony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// É responsável por dispor diversas funcionalidades, sem que para isso tenhamos que fazer qualquer configuração
@SpringBootApplication
public class MusicHarmonyApplication {
	public static void main(String[] args) {
			SpringApplication.run(MusicHarmonyApplication.class, args);
	}
}