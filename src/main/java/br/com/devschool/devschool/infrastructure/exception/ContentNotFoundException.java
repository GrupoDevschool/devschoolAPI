package br.com.devschool.devschool.infrastructure.exception;

public class ContentNotFoundException extends RuntimeException{

	public ContentNotFoundException(String message) {
		super(message);
	}
	
}
