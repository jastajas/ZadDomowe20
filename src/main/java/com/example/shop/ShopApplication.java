package com.example.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		SpringApplication.run(ShopApplication.class, args);
	}
}
