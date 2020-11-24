package br.com.test;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.LocalDateTime;

public class SomeService implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

	@PostConstruct
	public void init() {
		message = "New message at: " + LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

}
