package com.brasileirao.championship;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CampeonatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampeonatoApplication.class, args);
		byte[] keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();
		String base64Key = Base64.getEncoder().encodeToString(keyBytes);
		System.out.println(base64Key);
	}


}
