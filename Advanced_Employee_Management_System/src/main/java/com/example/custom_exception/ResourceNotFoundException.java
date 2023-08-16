package com.example.custom_exception;

public class ResourceNotFoundException extends Exception {
	public ResourceNotFoundException(String mesg) {
		super(mesg);
	}
}
