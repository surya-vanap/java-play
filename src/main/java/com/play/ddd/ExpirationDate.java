package com.play.ddd;

import java.time.LocalDateTime;

public class ExpirationDate {

	private static final long serialVersionUID = 1L;

	public static final ExpirationDate INFINITE = new ExpirationDate(null);
	private LocalDateTime _value;

	public LocalDateTime getValue() {
		return _value;
	}

	private ExpirationDate(LocalDateTime value) {
		_value = value;
	}

	public boolean IsExpired() {
		return this != INFINITE && _value.isBefore(LocalDateTime.now());
	}

	public static ExpirationDate Create(LocalDateTime value) {
		return new ExpirationDate(value);
	}
}
