package com.play.springboot;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HolaController {

	@GetMapping
	public final String hola() throws UnknownHostException {
		return "Hola!" + InetAddress.getLocalHost().getHostAddress();
	}
}
